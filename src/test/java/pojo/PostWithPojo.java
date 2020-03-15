package pojo;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class PostWithPojo {
    @Test
    public void pojoTest() throws Exception{
        UserPojo userPojo = new UserPojo("Jim", "Brown", 111, true, new BookingPojo("2018-01-01", "2019-01-01"), "Breakfast");
        // jackson library will be used.
        // object to json,xml -> serialization
        ObjectMapper objectMapper = new ObjectMapper();
        String stringRequest = objectMapper.writeValueAsString(userPojo);
        JSONParser jsonParser = new JSONParser();
        // parse string request to jsonObject
        JSONObject requestJson = (JSONObject)jsonParser.parse(stringRequest);
        System.out.println("Request json{}\n"+requestJson);
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(requestJson);
        Response response = requestSpecification.post("/booking");
        System.out.println(response.body().asString());
    }
}
