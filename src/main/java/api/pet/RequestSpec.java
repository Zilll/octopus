package api.pet;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.specification.RequestSpecification;

import static api.pet.Path.BASE_URI;
import static io.restassured.RestAssured.given;

public class RequestSpec {
    RequestSpecification reqSpec;
    public RequestSpecification RequestSpecification(){
        reqSpec = given().filter(new AllureRestAssured()).baseUri(BASE_URI)
                .log().everything();
        return reqSpec;
    }
}
