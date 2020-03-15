package Utilities;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * author Love
 */
public class RestClient {

    // Http Methods
    //1. get
    //2. put
    //3. post
    //4. delete

    public Response sendRequest(Api api)
    {
        setBaseUri(api);
        RequestSpecification reqest =  getRequest(api);
        Response response = getResponse(api,reqest);
        return response;
    }

    public void setBaseUri(Api api){
        RestAssured.baseURI = api.getBaseUrl();
    }

    public RequestSpecification getRequest(Api api){
        RequestSpecification request = RestAssured.given().log().all();
        setHeaders(api,request);
        setQueryParams(api,request);
        return request;
    }

    public Response getResponse(Api api,RequestSpecification request){
        String httpMethod = api.getHttpMethod();
        String path = api.getPath();
        Response response = null;
        if(httpMethod.equalsIgnoreCase("get")){
            response = request.get(path);
        }else if(httpMethod.equalsIgnoreCase("post")){
            response = request.post(path);
        }
        else if(httpMethod.equalsIgnoreCase("put")){
            response = request.put(path);
        }
        else if(httpMethod.equalsIgnoreCase("del")){
            response = request.delete(path);
        }
        return response;
    }

    public void setHeaders(Api api,RequestSpecification requestSpecification){
        if(!api.getHeaders().isEmpty()){
            requestSpecification.headers(api.getHeaders());
        }
    }

    public void setQueryParams(Api api,RequestSpecification requestSpecification){
        if(!api.getQueryParams().isEmpty()){
            requestSpecification.queryParams(api.getQueryParams());
        }
    }

    public JsonPath convertResponseToJsonPath(Response response){
          return  response.body().jsonPath();
    }


}
