package api.pet;

import api.pet.Data;
import api.pet.post.BodyPetPost;
import api.pet.RequestSpec;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static api.pet.Data.getPetId;
import static api.pet.Path.*;

@Epic("REST API Regression Testing")
@Feature("Verify CRUD Operations on pet module")
public class PostPetTest {
    Response response;
    RequestSpec requestSpec = new RequestSpec();
    Data data = new Data();
    BodyPetPost bodyPetPost = new BodyPetPost();

    @Test(testName = "POST /pet Add a new pet to the store statusCode(200)", priority = 1)
    @Description("POST /pet Add a new pet to the store statusCode(200)")
    @Story("POST request")
    public void petCreated() {
        SoftAssert softAssert = new SoftAssert();
        response = requestSpec.RequestSpecification().contentType(ContentType.JSON)
                .body(bodyPetPost.bodyCreatePet(
                        data.setPetId(),
                        2,
                        "checkdogs",
                        "checkmimi",
                        "checkurls",
                        10,
                        "checktagsname",
                        "checkavailable"))
                .post(create_post_by_pet_id);
        response.then().assertThat().statusCode(200).log().everything();
        softAssert.assertEquals(response.jsonPath().getInt("id"), getPetId(), "Pet wrong id");
        softAssert.assertEquals(response.jsonPath().getInt("category.id"), 2, "Pet wrong category.id");
        softAssert.assertEquals(response.jsonPath().getString("category.name"), "checkdogs", "Pet wrong category.name");
        softAssert.assertEquals(response.jsonPath().getString("name"), "checkmimi", "Pet wrong name");
        softAssert.assertEquals(response.jsonPath().getString("photoUrls[0]"), "checkurls", "Pet wrong photoUrls");
        softAssert.assertEquals(response.jsonPath().getInt("tags[0].id"), 10, "Pet wrong tags.id");
        softAssert.assertEquals(response.jsonPath().getString("tags[0].name"), "checktagsname", "Pet wrong tags.name");
        softAssert.assertEquals(response.jsonPath().getString("status"), "checkavailable", "Pet wrong status");
        softAssert.assertAll();
    }

    @Story("POST request")
    @Test(testName = "POST /pet Add a new pet to the store statusCode(405)", priority = 2)
    public void petNotCreated() {
        response = requestSpec.RequestSpecification().contentType(ContentType.JSON)
                .post(create_post_by_pet_id);
        response.then().assertThat().statusCode(405).log().everything();
    }

    @Story("POST request")
    @Test(testName = "POST /pet/{petId} Updates a pet in the store with form data statusCode(200)", priority = 3)
    public void petUpdated() {
        data.setName("updatedName");
        data.setStatus("updatedStatus");
        response = requestSpec.RequestSpecification()
                .contentType("application/x-www-form-urlencoded")
                .param("name", data.getName())
                .param("status", data.getStatus())
                .post(update_post_by_pet_id + getPetId());
        response.then().assertThat().statusCode(200).log().everything();
    }

    @Story("POST request")
    @Test(testName = "POST /pet/{petId} Updates a pet in the store with form data statusCode(405)", priority = 4)
    public void petNotUpdated() {
        response = requestSpec.RequestSpecification()
                .contentType("application/x-www-form-urlencoded")
                .param("name", data.getName())
                .param("status", data.getStatus())
                .patch(update_post_by_pet_id + getPetId());
        response.then().assertThat().statusCode(405).log().everything();
    }


}
