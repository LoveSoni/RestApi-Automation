package apiTests;

import Utilities.Api;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class test {
    @Test
    public void test1(){
        String baseUrl = "https://gorest.co.in";
        String path = "/users";
        Map<String,String> queryParms = new HashMap<String, String>(){
                {
                    put("first_name","first");
                }
        };
        Api apiObject = new Api(baseUrl,"get",path,queryParms,);
    }
}
