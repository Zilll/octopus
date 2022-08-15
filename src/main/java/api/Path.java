package api;

public class Path {
    //Pet
    public static String PET = "pet";
    public static String FIND_BY_STATUS = "findByStatus";
    //Store
    public static String STORE = "store";
    public static String ORDER = "order";
    public static String INVENTORY = "inventory";
    public static int ORDER_NUMBER = 25;
    //Common
    public static String V2 = "v2";
    public static String SOLD = "sold";
    public static String STATUS = "status";
    public static String SLASH = "/";

    public static String BASE_URI = "https://petstore.swagger.io";
    public static String path_find_by_status = BASE_URI + SLASH + V2 + SLASH + PET + SLASH + FIND_BY_STATUS;
    public static String update_post_by_pet_id = BASE_URI + SLASH + V2 + SLASH + PET + SLASH;
    public static String create_post_by_pet_id = BASE_URI + SLASH + V2 + SLASH + PET;
    //Store
    public static String create_order = BASE_URI + SLASH + V2 + SLASH + STORE + SLASH + ORDER;
    public static String get_order = BASE_URI + SLASH + V2 + SLASH + STORE + SLASH + ORDER + SLASH;
    public static String get_order_inventory = BASE_URI + SLASH + V2 + SLASH + STORE + SLASH + INVENTORY;
}
