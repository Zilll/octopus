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
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Epic("REST API Regression Testing")
@Feature("Verify CRUD Operations on store module")
public class GetOrderTest {
    Response response;
    RequestSpec requestSpec = new RequestSpec();

    @Story("GET request")
    @Test(testName = "GET /store/order/{orderId} Find purchase order by ID statusCode(200)", priority = 1)
    public void orderFoundById() {
        response = requestSpec.RequestSpecification()
                .contentType(ContentType.JSON)
                .get(get_order + ORDER_NUMBER);
        response.then().assertThat().statusCode(200).log().everything();
    }

    @Story("GET request")
    @Test(testName = "GET /store/order/{orderId} Find purchase order by ID statusCode(404)", priority = 2)
    public void orderNotFound() {
        response = requestSpec.RequestSpecification()
                .contentType(ContentType.JSON)
                .get(get_order + "245");
        response.then().assertThat().statusCode(404).log().everything();
    }
    @Story("GET request")
    @Test(testName = "GET /store/inventory Returns pet inventories by status statusCode(200)", priority = 3)
    public void orderFoundByInventory() {
        response = requestSpec.RequestSpecification()
                .contentType(ContentType.JSON)
                .get(get_order_inventory);
        response.then().
                statusCode(200)
                .body("putstatavailable", equalTo(1))
                .log().everything();
    }

}
