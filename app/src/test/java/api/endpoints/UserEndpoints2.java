package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {

    //method created for getting URL's from props file
    static ResourceBundle getURL() {
        ResourceBundle routes = ResourceBundle.getBundle("routes"); //Load Properties file
        return routes;
    }

    public static Response createUser(User payload) {

        String post_url = getURL().getString("user_post_url");
        Response response = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)
        .when()
            .post(post_url);

        return response;
    };

    public static Response readUser(String userName) {
        String user_get_url = getURL().getString("user_get_url");

        Response response = given()
            .pathParam("username", userName)
        .when()
            .get(user_get_url);

        return response;
    };

    public static Response updateUser(String userName, User payload) {
        String user_update_url = getURL().getString("user_update_url");

        Response response = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .pathParam("username", userName)
            .body(payload)
        .when()
            .put(user_update_url);

        return response;
    };

    public static Response deleteUser(String userName) {
        String user_delete_url = getURL().getString("user_delete_url");

        Response response = given()
            .pathParam("username", userName)
        .when()
            .delete(user_delete_url);

        return response;
    };
}
