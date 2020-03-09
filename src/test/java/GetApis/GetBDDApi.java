package GetApis;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class GetBDDApi {
    @Test
    public void getApiTest(){
        given().log().all()
                .when().log().all()
                .get("https://reqres.in/api/users?page=2")
                .then().log().all()
                .assertThat()
                .body("data.id",hasSize(6));
    }

    @Test
    public void getApiTest2(){
       Response response = given()
                .when()
                .get("https://reqres.in/api/users?page=2");
        int statusCode = response.getStatusCode();
        System.out.println("Status code :"+statusCode);
        Assert.assertEquals(statusCode,200);
        System.out.println("List of Response headers :"+response.getHeaders());
        System.out.println("Response body : "+ response.prettyPrint());
    }

    @Test
    public void getApiTest3(){
        baseURI = "http://ergast.com";
        Response response = given()
                .when()
                .get("/api/f1/2017/circuits.json");
        int statusCode = response.getStatusCode();
        System.out.println("Status code :"+statusCode);
        System.out.println("Respnse body :"+response.prettyPrint());
    }

    @Test
    public void getApiTest4(){
        baseURI = "http://ergast.com";
        given()
                .when()
                .get("/api/f1/2017/circuits.json")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and()
                .header("content-type","application/json; charset=utf-8")
                .and()
                .body("MRData.limit",equalTo("30"));
    }
}
