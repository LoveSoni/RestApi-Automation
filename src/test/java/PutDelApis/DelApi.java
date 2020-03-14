package PutDelApis;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DelApi {
    @Test
    public void deleteRecord(){
        // post  del
        RestAssured.baseURI = "https://gorest.co.in";
        RequestSpecification requestSpecification  = RestAssured.given().log().all();
        requestSpecification.auth().preemptive().oauth2("V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo");
        Response response =  requestSpecification.delete("/public-api/users/6071");
        System.out.println(response.body().asString());
    }
}
