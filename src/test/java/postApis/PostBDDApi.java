package postApis;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.File;

public class PostBDDApi {

    @Test
    public void postHitWithJSONString(){
        RestAssured.baseURI = "https://gorest.co.in";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email","tiim@gmail.com");
        jsonObject.put("first_name","first_name");
        jsonObject.put("last_name","last_name");
        jsonObject.put("gender","male");
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.auth().preemptive().oauth2("V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonObject.toJSONString());
        Response response = requestSpecification.post("/public-api/users");
        System.out.println(response.body().asString());
    }

    @Test void postHitWithJsonFile(){
        RestAssured.baseURI = "https://gorest.co.in";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.auth().preemptive().oauth2("V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"data"+File.separator+"newUser.json"));
        Response response = requestSpecification.post("/public-api/users");
        System.out.println(response.body().asString());
    }

}
