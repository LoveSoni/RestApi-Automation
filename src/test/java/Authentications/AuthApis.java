package Authentications;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

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
                .param("first_name","first")
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
}
