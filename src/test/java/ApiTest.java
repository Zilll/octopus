import api.pet.Path;
import io.restassured.response.Response;

import static api.pet.Path.*;

import static logger.Logger.logger;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.given;

public class ApiTest {
//    Response by_status;
//    Path path = new Path();
//    @BeforeClass
//    public void checkGet(){
//        by_status= requestBase(base_path_find_by_status);
//        by_status.prettyPrint();
//        logger.info(String.valueOf(by_status.path("$").toString()));
//        logger.info(String.valueOf(by_status.path("[0].id").toString()));
//        logger.info(String.valueOf(by_status.path("[0].category.name").toString()));
//        //logger.info(String.valueOf(by_status.path("$[0].id").toString()));
//        path.setPetId(String.valueOf(by_status.path("[0].id").toString()));
//    }
//    @Test(testName = "Check status code 200 on get pet",priority = 3)
//    public void checkStatusCode(){
//        by_status.then().assertThat().statusCode(200);
//    }
//    @Test(testName = "Check id on get pet",priority = 2)
//    public void checkStatusCode2(){
//
//        Assert.assertTrue(by_status.path("id").toString().contains(path.getPetId()),"No "+path.getPetId() +"at response");
//    }
//    @Test(testName = "Check POST /pet/{petId}", priority = 1)
//    public void checkByPetId(){
//        //SoftAssert softAsset =new SoftAssert();
//        by_status= requestBase(path.base_path_post_by_pet_id);
//        logger.info(path.base_path_post_by_pet_id);
//        logger.info(path.getPetId());
//        by_status.prettyPrint();
//        by_status.then().assertThat().statusCode(200);
//    }
    @Test
    public void check(){
        int randomInt = ThreadLocalRandom.current().nextInt(10,99999);
        System.out.println(randomInt);
    }
}
