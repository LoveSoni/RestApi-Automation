package schemaValidation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

public class ValidateSchema {
    @Test
    public void validateTest(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(new File(System.getProperty("user.dir")+"/src/test/java/schemaValidation/body.json"));
        Response response = requestSpecification.post("/booking");
        System.out.println(response.body().asString());
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("validateSchema.json"));
    }
}
