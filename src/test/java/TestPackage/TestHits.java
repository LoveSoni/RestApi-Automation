package TestPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TestHits {

    @Test
    public void getApi(){
        RestAssured.baseURI = "https://gorest.co.in";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization","Bearer V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo");
        requestSpecification.queryParam("first_name","first");
        Response response = requestSpecification.get("public-api/users");
        System.out.println(response.then().assertThat().statusCode(200));
        System.out.println(response.body().asString());
        System.out.println(response.getBody().jsonPath().get("_meta.message"));
    }

}
