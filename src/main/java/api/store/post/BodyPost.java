package api.store.post;

import org.json.JSONArray;
import org.json.JSONObject;

public class BodyPost {

    public String bodyCreateStore(Integer id, Integer petId, Integer quantity, String status){
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id",id);
        jsonObj.put("petId",petId);
        jsonObj.put("quantity",quantity);
        jsonObj.put("shipDate","2022-08-08T11:54:22.303Z");
        jsonObj.put("status",status);
        jsonObj.put("complete",true);
        return jsonObj.toString();
    }

}
