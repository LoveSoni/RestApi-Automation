package apiTests;

import Utilities.Api;
import Utilities.RestClient;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class test {
    @Test
    public void test1(){
        String baseUrl = "https://gorest.co.in";
        String path = "/public-api/users";
        Map<String,String> queryParms = new HashMap<String, String>(){
                {
                    put("first_name","first");
                }
        };
        Map<String,String> headers = new HashMap<String, String>(){
            {
                put("content-type","application/json");
                put("Authorization","Bearer V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo");
            }
        };
        Api apiObject = new Api(baseUrl,"get",path,queryParms,headers);
        RestClient restClient = new RestClient();
       JsonPath jsonPath = restClient.convertResponseToJsonPath(restClient.sendRequest(apiObject));
       System.out.println(jsonPath.prettyPrint());

    }
}
