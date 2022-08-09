package api.pet.post;

import org.json.JSONArray;
import org.json.JSONObject;

public class BodyPetPost {

    public String bodyCreatePet(Integer id, Integer categoryId, String categoryName, String name, String photoUrls, Integer tagsId, String tagsName, String status){
        JSONArray jsonArrTags = new JSONArray();
        JSONObject jsonObjCategory = new JSONObject();
        jsonObjCategory.put("id",categoryId);
        jsonObjCategory.put("name",categoryName);
        JSONObject jsonObjtags = new JSONObject();
        JSONArray jsonObjphotoUrls = new JSONArray();
        jsonObjphotoUrls.put(photoUrls);
        jsonObjtags.put("id",tagsId);
        jsonObjtags.put("name",tagsName);
        jsonArrTags.put(jsonObjtags);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id",id);
        jsonObj.put("category",jsonObjCategory);
        jsonObj.put("name",name);
        jsonObj.put("photoUrls",jsonObjphotoUrls);
        jsonObj.put("tags",jsonArrTags);
        jsonObj.put("status",status);
        return jsonObj.toString();
    }

}
