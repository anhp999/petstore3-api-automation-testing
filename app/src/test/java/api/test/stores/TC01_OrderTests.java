package api.test.stores;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndpoints;
import io.restassured.response.Response;
import api.payload.Order;
import api.utilities.OrderStatus;

public class TC01_OrderTests {

    Faker faker;
    Order order;

    public Logger logger;

    @BeforeClass
    public void setupData() {
        faker = new Faker();
        order = new Order();

        order.setId(faker.idNumber().hashCode());
        order.setPetId(faker.idNumber().hashCode());
        order.setQuantity(faker.number().hashCode());
        order.setShipDate(faker.date().future(2, TimeUnit.DAYS));
        order.setStatus(OrderStatus.placed);

        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void testPlaceAnOrder() {
        logger.info("======== Placing An Order ========");
        Response response = StoreEndpoints.placeOrder(order);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("======== Order Is Created ========");
    }

    @Test(priority = 2)
    public void testGetPurchaseOrderById() {
        logger.info("======== Finding Purchase Order ========");
        Response response = StoreEndpoints.findPurchaseOrder(this.order.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("======== Purchase Order Is Found ========");
    }

    @Test(priority = 3)
    public void testPetInventory() {
        logger.info("======== Reading Inventory ========");
        Response response = StoreEndpoints.readInventory();
        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("======== Inventory Present ========");
    }
}