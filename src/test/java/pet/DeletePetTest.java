package pet;

import api.pet.Data;
import api.pet.RequestSpec;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static api.pet.Data.getPetId;
import static api.pet.Path.update_post_by_pet_id;

public class DeletePetTest {
    Response response;
    RequestSpec requestSpec = new RequestSpec();
    Data data =new Data();
    @Test(testName = "DELETE /pet/{petId} Deletes a pet statusCode(200)", priority = 1)
    public void deletePetStatusCode200() {
        response = requestSpec.RequestSpecification()
                .contentType(ContentType.JSON)
                .delete(update_post_by_pet_id + getPetId());
        response.then().assertThat().statusCode(200).log().everything();
    }
    @Test(testName = "DELETE /pet/{petId} Deletes a pet statusCode(404)", priority = 2)
    public void deletePetStatusCode404() {
        response = requestSpec.RequestSpecification()
                .contentType(ContentType.JSON)
                .delete(update_post_by_pet_id + "d");
        response.then().assertThat().statusCode(404).log().everything();
    }
}
