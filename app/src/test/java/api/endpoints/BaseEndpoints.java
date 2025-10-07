package api.endpoints;

import java.util.ResourceBundle;

public class BaseEndpoints {

    // Load routes.properties from src/test/resources
    private static final ResourceBundle routes = ResourceBundle.getBundle("routes");

    // Base URL
    private static final String base_url = routes.getString("base_url");

    // -------------------- User module --------------------
    public static final String user_post_url = attachURL("/user");
    public static final String user_get_url = attachURL("/user/{username}");
    public static final String user_update_url = attachURL("/user/{username}");
    public static final String user_delete_url = attachURL("/user/{username}");

    // -------------------- Store module --------------------
    public static final String store_post_url = attachURL("/store/order");
    public static final String store_get_url = attachURL("/store/inventory");
    public static final String store_get_by_id_url = attachURL("/store/order/{orderId}");
    public static final String store_delete_url = attachURL("/store/order/{orderId}");

    // -------------------- Pet module --------------------
    public static final String pet_post_url = attachURL("/pet");
    public static final String pet_update_url = attachURL("/pet");
    public static final String pet_get_by_status_url = attachURL("/pet/findByStatus");
    public static final String pet_get_by_tags_url = attachURL("/pet/findByTags");
    public static final String pet_get_by_id_url = attachURL("/pet/{petId}");
    public static final String pet_post_by_id_url = attachURL("/pet/{petId}");
    public static final String pet_delete_by_id_url = attachURL("/pet/{petId}");
    public static final String pet_post_images_url = attachURL("/pet/{petId}/uploadImage");

    private static String attachURL(String path) {
        return base_url + path;
    }
}
