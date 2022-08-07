package api.pet.post;

import org.json.JSONArray;
import org.json.JSONObject;

public class BodyPut {
    public String bodyUpdatePet(Integer id, Integer categoryId, String categoryName, String name, String photoUrls, Integer tagsId, String tagsName, String status){
        JSONArray jsonArrtags = new JSONArray();
        JSONObject jsonObjcategory = new JSONObject();
        jsonObjcategory.put("id",categoryId);
        jsonObjcategory.put("name",categoryName);
        JSONObject jsonObjtags = new JSONObject();
        JSONArray jsonObjphotoUrls = new JSONArray();
        jsonObjphotoUrls.put(photoUrls);
        jsonObjtags.put("id",tagsId);
        jsonObjtags.put("name",tagsName);
        jsonArrtags.put(jsonObjtags);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id",id);
        jsonObj.put("category",jsonObjcategory);
        jsonObj.put("name",name);
        jsonObj.put("photoUrls",jsonObjphotoUrls);
        jsonObj.put("tags",jsonArrtags);
        jsonObj.put("status",status);
        return jsonObj.toString();
    }
}
