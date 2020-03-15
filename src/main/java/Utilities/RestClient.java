package Utilities;


import org.json.simple.JSONObject;
import io.restassured.module.*;

import java.util.Map;

/**
 * author Love
 */
public class RestClient {

    // Http Methods
    //1. get
    //2. put
    //3. post
    //4. delete

    public void getRequestSpecification(String httpMethod,String baseUrl,String path,Map<String,String> headers){
        if(httpMethod.equalsIgnoreCase("get")){

        }
        else if(httpMethod.equalsIgnoreCase("post")){

        }
        else if(httpMethod.equalsIgnoreCase("put")){

        }
        else if(httpMethod.equalsIgnoreCase("patch")){

        }
        else if(httpMethod.equalsIgnoreCase("del")){

        }
    }

    public void sendRequest(String httpMethod, String baseUrl, String path, Map<String,String> headers, JSONObject jsonObject){


    }

    public void sendRequest(String httpMethid,String baseUrl,String path,Map<String,String> headers){

    }
}
