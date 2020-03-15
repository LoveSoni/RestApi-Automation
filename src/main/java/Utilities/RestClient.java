package Utilities;


import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import sun.misc.Request;

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

    public void sendRequest(Api api)
    {
        setBaseUri(api);
        getRequest(api);
    }

    public void setBaseUri(Api api){
        RestAssured.baseURI = api.getBaseUrl();
    }

    public RequestSpecification getRequest(Api api){
        String httpMethod = api.getHttpMethod();
        RequestSpecification request = RestAssured.given().log().all();
        if(httpMethod.equalsIgnoreCase("get")){

        }else if(httpMethod.equalsIgnoreCase("post")){

        }
        else if(httpMethod.equalsIgnoreCase("put")){

        }
        else if(httpMethod.equalsIgnoreCase("del")){

        }
     return request;
    }

    public void setHeaders(Api api,RequestSpecification requestSpecification){
        if(!api.getHeaders().isEmpty(){
            requestSpecification.headers(api.getHeaders());
        }
    }

    public void setQueryParams(Api api,RequestSpecification requestSpecification){
        if(!api.getQueryParams().isEmpty()){
            requestSpecification.queryParams(api.getQueryParams());
        }
    }


}
