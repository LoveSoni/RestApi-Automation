package putDelApis;

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
    public void putCall() throws  Exception{
        GoRestUser goRestUser = new GoRestUser("k2e11011@gmail.com","firstTime","lastname","male");
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
        System.out.println("Response json{}\n"+response.body().asString());
        String userId = response.body().jsonPath().getString("result.id");
        System.out.println("user id :"+userId);
        //After creating the data now update the user details using put call
        goRestUser.setEmail("newTest@gmail.com");
        String updatedRequest = objectMapper.writeValueAsString(goRestUser);
        System.out.println("Updated Request json{}\n"+updatedRequest);
        RequestSpecification putSpecification = RestAssured.given().log().all();
        putSpecification.contentType(ContentType.JSON);
        putSpecification.body(updatedRequest);
        putSpecification.auth().preemptive().oauth2("V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo");
        Response putResponseJson = putSpecification.put("/public-api/users/"+userId);
        System.out.println(putResponseJson.body().asString());

    }
}
