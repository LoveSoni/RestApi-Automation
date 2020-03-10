package Authentications;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;

public class AuthApis {
    //basic auth - username and password

    @Test
    public void basicAuth(){
        baseURI = "https://the-internet.herokuapp.com/basic_auth";
        given().log().all()
                .auth()
                .preemptive()
                .basic("admin","admin")
                .when().log().all()
                .get()
                .then().log().all()
                .statusCode(200);
    }

    //oauth2.0 access token (clientid,client secret, grant permission)
    @Test
    public void oauth2_0(){
        baseURI = "https://gorest.co.in";
        given().log().all()
                .param("first_name","first")
                .auth()
                .oauth2("V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo")
                .when().log().all()
                .get("/public-api/users")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void tokenInHeader(){
        baseURI = "https://gorest.co.in";
        given().log().all()
                .queryParam("first_name","first")
                .headers(new HashMap<String,String>(){
                    {
                        put("Authorization","Bearer V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo");
                    }
                })
                .when()
                .get("/public-api/users")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void generateOauth2_Using_FormData(){
       RequestSpecification request =  RestAssured.given()
                .formParam("client_id","NovApiApp")
                .formParam("client_secret","24cb2ed6a3ffceb4b10733e845e91963")
                .formParam("grant_type","client_credentials");
       Response response = request.post("http://coop.apps.symfonycasts.com/token");
       System.out.println(response.getStatusCode());
       System.out.println(response.prettyPrint());
    }

    @Test
    public void getResponseFromResponseObject(){
      RequestSpecification  request =  RestAssured.given()
                .auth()
                .preemptive()
                .oauth2("V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo");
        Response response = request.get("https://gorest.co.in");
      System.out.println("Print entire JsonPath :"+response.prettyPrint());
    }
}
