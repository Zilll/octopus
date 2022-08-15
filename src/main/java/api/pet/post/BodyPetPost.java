package api.pet.post;

import org.json.JSONArray;
import org.json.JSONObject;

import static api.RequestKeys.*;

public class BodyPetPost {

    public String bodyCreatePet(Integer id, Integer categoryId, String categoryName, String name, String photoUrls, Integer tagsId, String tagsName, String status){
        JSONArray jsonArrTags = new JSONArray();
        JSONObject jsonObjCategory = new JSONObject();
        jsonObjCategory.put(ID,categoryId);
        jsonObjCategory.put(NAME,categoryName);
        JSONObject jsonObjtags = new JSONObject();
        JSONArray jsonObjphotoUrls = new JSONArray();
        jsonObjphotoUrls.put(photoUrls);
        jsonObjtags.put(ID,tagsId);
        jsonObjtags.put(NAME,tagsName);
        jsonArrTags.put(jsonObjtags);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(ID,id);
        jsonObj.put(CATEGORY,jsonObjCategory);
        jsonObj.put(NAME,name);
        jsonObj.put(PHOTO_URLS,jsonObjphotoUrls);
        jsonObj.put(TAGS,jsonArrTags);
        jsonObj.put(STATUS,status);
        return jsonObj.toString();
    }

}
