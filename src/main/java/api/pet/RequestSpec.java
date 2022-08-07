package api.pet;

import io.restassured.specification.RequestSpecification;

import static api.pet.Path.BASE_URI;
import static io.restassured.RestAssured.given;

public class RequestSpec {
    RequestSpecification reqSpec;
    public RequestSpecification RequestSpecification(){
        reqSpec = given().baseUri(BASE_URI)
                .log().everything();
        return reqSpec;
    }
}
