package store;

import api.pet.RequestSpec;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static api.pet.Data.getPetId;
import static api.pet.Path.*;

@Epic("REST API Regression Testing")
@Feature("Verify CRUD Operations on store module")
public class DeleteOrderTest {
    Response response;
    RequestSpec requestSpec = new RequestSpec();

    @Story("DELETE request")
    @Test(testName = "DELETE /pet/{petId} Deletes a pet statusCode(200)", priority = 1)
    public void deletePetStatusCode200() {
        response = requestSpec.RequestSpecification()
                .contentType(ContentType.JSON)
                .delete(get_order + ORDER_NUMBER);
        response.then().assertThat().statusCode(200).log().everything();
    }

    @Story("DELETE request")
    @Test(testName = "DELETE /pet/{petId} Deletes a pet statusCode(404)", priority = 2)
    public void deletePetStatusCode404() {
        response = requestSpec.RequestSpecification()
                .contentType(ContentType.JSON)
                .delete(get_order + ORDER_NUMBER);
        response.then().assertThat().statusCode(404).log().everything();
    }
}
