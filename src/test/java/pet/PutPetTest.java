package pet;

import api.pet.Data;
import api.pet.RequestSpec;
import api.pet.post.BodyPut;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static api.pet.Data.getPetId;
import static api.pet.Path.create_post_by_pet_id;

public class PutPetTest {
    Response response;
    RequestSpec requestSpec = new RequestSpec();
    Data data = new Data();
    BodyPut bodyPut = new BodyPut();

    @Feature("API")
    @Story("Pet API")
    @Test(testName = "PUT /pet Update an existing pet statusCode(200)", priority = 9)
    public void checkPutByPetId() {
        SoftAssert softAssert = new SoftAssert();
        response = requestSpec.RequestSpecification().contentType(ContentType.JSON)
                .body(bodyPut.bodyUpdatePet(
                        getPetId(),
                        5,
                        "putdogs",
                        "putmimi",
                        "puturls",
                        9,
                        "puttagsname",
                        "putavailable"))
                .put(create_post_by_pet_id);
        response.then().assertThat().statusCode(200).log().everything();
        softAssert.assertEquals(response.jsonPath().getInt("id"), getPetId(), "Pet wrong id");
        softAssert.assertEquals(response.jsonPath().getInt("category.id"), 5, "Pet wrong category.id");
        softAssert.assertEquals(response.jsonPath().getString("category.name"), "putdogs", "Pet wrong category.name");
        softAssert.assertEquals(response.jsonPath().getString("name"), "putmimi", "Pet wrong name");
        softAssert.assertEquals(response.jsonPath().getString("photoUrls[0]"), "puturls", "Pet wrong photoUrls");
        softAssert.assertEquals(response.jsonPath().getInt("tags[0].id"), 9, "Pet wrong tags.id");
        softAssert.assertEquals(response.jsonPath().getString("tags[0].name"), "puttagsname", "Pet wrong tags.name");
        softAssert.assertEquals(response.jsonPath().getString("status"), "putavailable", "Pet wrong status");
        softAssert.assertAll();
    }

    @Feature("API")
    @Story("Pet API")
    @Test(testName = "PUT /pet Update an existing pet statusCode(405)", priority = 10)
    public void checkPutWrongByPetId() {
        SoftAssert softAssert = new SoftAssert();
        response = requestSpec.RequestSpecification().contentType(ContentType.JSON)
                .put(create_post_by_pet_id);
        response.then().assertThat().statusCode(405).log().everything();
        softAssert.assertAll();
    }
}
