package api.pet;

public class Path {
    public static String PET = "pet";
    public static String FIND_BY_STATUS =  "findByStatus";
    public static String V2=  "v2";
    public static String SOLD =  "sold";
    public static String STATUS =  "status";
    public static String SLASH = "/";

    public static String BASE_URI = "https://petstore.swagger.io";
    public static String path_find_by_status =BASE_URI+SLASH+V2+SLASH+PET+SLASH+FIND_BY_STATUS;
    public static String update_post_by_pet_id =BASE_URI+SLASH+V2+SLASH+PET+SLASH;
    public static String create_post_by_pet_id =BASE_URI+SLASH+V2+SLASH+PET;
}
