package api.pet.post;

import org.json.JSONArray;
import org.json.JSONObject;

import static api.RequestKeys.*;

public class BodyPetPut {
    public String bodyUpdatePet(Integer id, Integer categoryId, String categoryName, String name, String photoUrls, Integer tagsId, String tagsName, String status){
        JSONArray jsonArrtags = new JSONArray();
        JSONObject jsonObjcategory = new JSONObject();
        jsonObjcategory.put(ID,categoryId);
        jsonObjcategory.put(NAME,categoryName);
        JSONObject jsonObjtags = new JSONObject();
        JSONArray jsonObjphotoUrls = new JSONArray();
        jsonObjphotoUrls.put(photoUrls);
        jsonObjtags.put(ID,tagsId);
        jsonObjtags.put(NAME,tagsName);
        jsonArrtags.put(jsonObjtags);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(ID,id);
        jsonObj.put(CATEGORY,jsonObjcategory);
        jsonObj.put(NAME,name);
        jsonObj.put(PHOTO_URLS,jsonObjphotoUrls);
        jsonObj.put(TAGS,jsonArrtags);
        jsonObj.put(STATUS,status);
        return jsonObj.toString();
    }
}
