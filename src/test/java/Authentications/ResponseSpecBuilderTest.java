package Authentications;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class ResponseSpecBuilderTest {
    // lets say we have
    // multiple test cases like Test1, Test2, Test3
    // All these test cases following content is common in the response
    // status code
    // content type
    @Test
    public void responseSpecification() {
        RestAssured.baseURI = "https://gorest.co.in";
        RequestSpecification requestSpecification = RestAssured.given();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","tim@gmail.com");
        requestSpecification.auth().preemptive().oauth2("V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo");
        Response response = requestSpecification.post("/public-api/users");
        System.out.println(response.prettyPrint());
    }
}
