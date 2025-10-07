package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.List;

import api.payload.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndpoints extends BaseEndpoints {

    public static Response addNewPet(Pet payload) {
        Response response = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)
        .when()
            .post(pet_post_url);

        return response;
    };

    public static Response findPetsByStatus(String status) {
        Response response = given()
            .queryParam("status", status)
        .when()
            .get(pet_get_by_status_url);

        return response;
    };

    public static Response findPetsByTags(List<String> tags) {
        Response response = given()
            .queryParam("tags", tags)
        .when()
            .get(pet_get_by_tags_url);

        return response;
    };

    public static Response findPetById(int id) {
        Response response = given()
            .pathParam("petId", id)
        .when()
            .get(pet_get_by_id_url);

        return response;
    };

    public static Response updatePet(Pet payload) {
        Response response = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)
        .when()
            .put(pet_update_url);

        return response;
    };

    public static Response updatePetFormData(String id) {
        Response response = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .pathParam("petId", id)
        .when()
            .post(pet_post_url);

        return response;
    };

    public static Response uploadPetImage(String id) {
        Response response = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .pathParam("petId", id)
        .when()
            .post(pet_post_images_url);

        return response;
    };

    public static Response deleteAPetById(String id) {
        Response response = given()
            .pathParam("petId", id)
        .when()
            .delete(pet_delete_by_id_url);

        return response;
    };
}
