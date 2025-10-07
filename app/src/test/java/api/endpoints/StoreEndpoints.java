package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.Order;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndpoints extends BaseEndpoints {

    public static Response placeOrder(Order payload) {

        Response response = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)
        .when()
            .post(store_post_url);

        return response;
    };

    public static Response readInventory() {
        Response response = given()
        .when()
            .get(store_get_url);

        return response;
    };

    public static Response findPurchaseOrder(long orderId) {
        Response response = given()
            .pathParam("orderId", orderId)
        .when()
            .get(store_get_by_id_url);

        return response;
    };

    public static Response deletePurchaseOrder(String orderId) {
        Response response = given()
            .pathParam("orderId", orderId)
        .when()
            .delete(store_delete_url);

        return response;
    };
}
