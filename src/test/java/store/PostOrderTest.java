package store;

import api.pet.Data;
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
@Feature("Verify CRUD Operations on order module")
public class PostOrderTest {
    Response response;
    RequestSpec requestSpec = new RequestSpec();
    Data data = new Data();
    api.store.post.BodyPost bodyPost = new api.store.post.BodyPost();

    @Test(testName = "POST /store/order Place an order for a pet statusCode(200)", priority = 1)
    @Description("POST /store/order Place an order for a pet statusCode(200)")
    @Story("POST request")
    public void orderCreated() {
        SoftAssert softAssert = new SoftAssert();
        response = requestSpec.RequestSpecification().contentType(ContentType.JSON)
                .body(bodyPost.bodyCreateStore(
                        ORDER_NUMBER,
                        37172,
                        1,
                        "personal"))
                .post(create_order);
        response.then().assertThat().statusCode(200).log().everything();
        softAssert.assertEquals(response.jsonPath().getInt("id"), ORDER_NUMBER, "Store wrong id");
        softAssert.assertEquals(response.jsonPath().getInt("petId"), 37172, "Store wrong petId");
        softAssert.assertEquals(response.jsonPath().getInt("quantity"), 1, "Store wrong quantity");
        softAssert.assertEquals(response.jsonPath().getString("shipDate"), "2022-08-08T11:54:22.303+0000", "Store wrong shipDate");
        softAssert.assertEquals(response.jsonPath().getString("status"), "personal", "Store wrong status");
        softAssert.assertEquals(response.jsonPath().getString("complete"), "true", "Store wrong complete");
        softAssert.assertAll();
    }

    @Story("POST request")
    @Test(testName = "POST /store/order Place an order for a pet statusCode(400)", priority = 2)
    public void orderNotCreated() {
        response = requestSpec.RequestSpecification().contentType(ContentType.JSON)
                .body("")
                .post(create_order);
        response.then().assertThat().statusCode(400).log().everything();
    }
}
