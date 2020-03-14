package PutDelApis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class PutApi {
    @Test
    public void putCall(){
        GoRestUser goRestUser = new GoRestUser("new@gmail.com","firstTime","lastname","male");
        String request = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
           request =  objectMapper.writeValueAsString(goRestUser);
        }catch (JsonProcessingException exception){
            exception.printStackTrace();
        }
        JSONParser jsonParser = new JSONParser();
        JSONObject requestJson = null;
        try {
            requestJson = (JSONObject) jsonParser.parse(request);
        }catch (ParseException e)
        {
            e.printStackTrace();
        }
        System.out.println("Request json{}\n"+requestJson);
        RestAssured.baseURI = "https://gorest.co.in";
        RequestSpecification requestSpecification  = RestAssured.given();
        requestSpecification.auth().preemptive().oauth2("V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(requestJson);
        Response response =  requestSpecification.post("/public-api/users");
        System.out.println("Resonse json{}\n"+response.body().asString());

    }
}
