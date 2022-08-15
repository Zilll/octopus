package api.pet;

import api.RequestSpec;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static api.pet.Data.getPetId;
import static api.Path.update_post_by_pet_id;

@Epic("REST API Regression Testing")
@Feature("Verify CRUD Operations on pet module")
public class DeletePetTest {
    Response response;
    RequestSpec requestSpec = new RequestSpec();

    @Story("DELETE request")
    @Test(testName = "DELETE /pet/{petId} Deletes a pet statusCode(200)", priority = 1)
    public void petDeleted() {
        response = requestSpec.RequestSpecification()
                .contentType(ContentType.JSON)
                .delete(update_post_by_pet_id + getPetId());
        response.then().assertThat().statusCode(200).log().everything();
    }

    @Story("DELETE request")
    @Test(testName = "DELETE /pet/{petId} Deletes a pet statusCode(404)", priority = 2)
    public void petNotDeleted() {
        response = requestSpec.RequestSpecification()
                .contentType(ContentType.JSON)
                .delete(update_post_by_pet_id + "d");
        response.then().assertThat().statusCode(404).log().everything();
    }
}
