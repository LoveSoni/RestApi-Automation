package responseSpec;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

public class ResponseSpecBuilderTest {
    // lets say we have
    // multiple test cases like Test1, Test2, Test3
    // All these test cases following content is common in the response
    // status code
    // content type

    public ResponseSpecification getResponseSpecification() {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        ResponseSpecification responseSpecification = responseSpecBuilder.
                expectStatusCode(200).
                expectContentType(ContentType.JSON).build();
        return responseSpecification;
    }

    @Test
    public void useResponseSpecification(){
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.get("/api/users/2").then().spec(getResponseSpecification());
        //System.out.println(response.body().asString());
        //System.out.println(response.body().jsonPath().get("data.email"));
    }
}
