package api.endpoints;

/*
 * https://petstore3.swagger.io
 * create user (Post) https://petstore3.swagger.io/api/v3/user
 * Get user (Get) https://petstore3.swagger.io/api/v3/user/{username}
 * Update user (Put) https://petstore3.swagger.io/api/v3/user/{username}
 * Delete user (Delete) https://petstore3.swagger.io/api/v3/user/{username}
 */

public class Routes {
    public static String base_url = "http://localhost:8080/api/v3";

    //User module

    public static String user_post_url = base_url + "/user";
    public static String user_get_url = base_url + "/user/{username}";
    public static String user_update_url = base_url + "/user/{username}";
    public static String user_delete_url = base_url + "/user/{username}";

    //Store module
    
    public static String store_post_url = base_url + "/store/order";
    public static String store_get_url = base_url + "/store/inventory";
    public static String store_get_by_id_url = base_url + "/store/order/{orderId}";
    public static String store_delete_url = base_url + "/store/order/{orderId}";

    //Pet module

    public static String pet_post_url = base_url + "/pet";
    public static String pet_update_url = base_url + "/pet";
    public static String pet_get_by_status_url = base_url + "/pet/findByStatus";
    public static String pet_get_by_tags_url = base_url + "/pet/findByTags";
    public static String pet_get_by_id_url = base_url + "/pet/{petId}";
    public static String pet_post_by_id_url = base_url + "/pet/{petId}";
    public static String pet_delete_by_id_url = base_url + "/pet/{petId}";
    public static String pet_post_images_url = base_url + "/pet/{petId}/uploadImage";

}
