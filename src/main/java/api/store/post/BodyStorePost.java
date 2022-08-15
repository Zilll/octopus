package api.store.post;

import org.json.JSONObject;
import org.yaml.snakeyaml.events.Event;

import static api.RequestKeys.*;

public class BodyStorePost {

    public String bodyCreateStore(Integer id, Integer petId, Integer quantity, String status) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(ID, id);
        jsonObj.put(PET_ID, petId);
        jsonObj.put(QUANTITY, quantity);
        jsonObj.put(SHIP_DATE, "2022-08-08T11:54:22.303Z");
        jsonObj.put(STATUS, status);
        jsonObj.put(COMPLETE, true);
        return jsonObj.toString();
    }

}
