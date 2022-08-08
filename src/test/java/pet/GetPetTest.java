package pet;

import api.pet.Data;
import api.pet.RequestSpec;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static api.pet.Data.getPetId;
import static api.pet.Path.path_find_by_status;
import static api.pet.Path.update_post_by_pet_id;

@Epic("REST API Regression Testing")
@Feature("Verify CRUD Operations on pet module")
public class GetPetTest {
    Response response;
    RequestSpec requestSpec = new RequestSpec();

    @Story("GET request")
    @Test(testName = "GET /pet/{petId}Find pet by ID statusCode(200)", priority = 5)
    public void getPetByIdStatusCode200() {
        response = requestSpec.RequestSpecification()
                .contentType(ContentType.JSON)
                .get(update_post_by_pet_id + getPetId());
        response.then().assertThat().statusCode(200).log().everything();
    }

    @Story("GET request")
    @Test(testName = "GET /pet/{petId}Find pet by ID statusCode(404)", priority = 6)
    public void getPetByIdStatusCode404() {
        response = requestSpec.RequestSpecification()
                .contentType(ContentType.JSON)
                .get(update_post_by_pet_id + 922337243);
        response.then().assertThat().statusCode(404).log().everything();
    }

    @Story("GET request")
    @Test(testName = "GET /pet/findByStatus Finds Pets by status statusCode(200)", priority = 7)
    public void getPetByStatusStatusCode200() {
        response = requestSpec.RequestSpecification()
                .contentType(ContentType.JSON)
                .param("status", "updatedStatus")
                .get(path_find_by_status);
        response.then().assertThat().statusCode(200).log().everything();
    }

    @Story("GET request")
    @Test(testName = "GET /pet/findByStatus Finds Pets by status statusCode(400)", priority = 8)
    public void getPetByWrongStatusStatusCode200() {
        response = requestSpec.RequestSpecification()
                .contentType(ContentType.JSON)
                .param("status", "noStatus")
                .get(path_find_by_status);
        response.then().assertThat().statusCode(400).log().everything();
    }
}
