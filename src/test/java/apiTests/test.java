package apiTests;

import Utilities.Api;
import Utilities.RestClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.*;

public class test {
    @Test
    public void getRequest() {
        String baseUrl = "https://gorest.co.in";
        String path = "/public-api/users";
        Map<String, String> queryParms = new HashMap<String, String>() {
            {
                put("first_name", "first");
            }
        };
        Map<String, String> headers = new HashMap<String, String>() {
            {
                put("content-type", "application/json");
                put("Authorization", "Bearer V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo");
            }
        };
        Api apiObject = new Api("get", baseUrl, path, queryParms, headers);
        RestClient restClient = new RestClient();
        Response response = restClient.sendRequest(apiObject);
        JsonPath jsonPath = restClient.convertResponseToJsonPath(response);
        System.out.println(response.prettyPrint());
        System.out.println("Limit is :" + jsonPath.get("_meta.rateLimit.limit"));
    }

    @Test
    public void postRequest() {
        String baseUrl = "https://gorest.co.in";
        String path = "/public-api/users";
        String httpMethod = "post";

        Map<String, String> headers = new HashMap<String, String>() {
            {
                put("content-type", "application/json");
                put("Authorization", "Bearer V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo");
            }
        };
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "timd@gmail.com");
        jsonObject.put("first_name", "firstTime");
        jsonObject.put("last_name", "lastTime");
        jsonObject.put("gender", "male");
        Api api =new Api(jsonObject,httpMethod,baseUrl,path,headers);
        RestClient restClient = new RestClient();
        Response response = restClient.sendRequest(api);
        System.out.println(response.prettyPrint());
    }
}
