package uploadFile;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class uploadData {

    @Test
    public void uploadFile(){
        RestAssured.baseURI = "http://dms-staging.cars24.team";
        Map<String,String> queryParams = new HashMap<String, String>();
        queryParams.put("","");
        queryParams.put("","");
        queryParams.put("","");
        queryParams.put("","");
        Map<String,String> headers = new HashMap<String, String>();
        headers.put("","");
        headers.put("","");
        headers.put("","");
        headers.put("Content-Type","multipart/form-data");
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParams(queryParams);
        requestSpecification.multiPart("file","value");
    }
}
