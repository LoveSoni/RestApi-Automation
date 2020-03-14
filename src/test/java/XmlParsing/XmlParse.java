package XmlParsing;

import static  io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class XmlParse {
    @Test
    public void getXMLResponse(){
        baseURI = "https://gorest.co.in";
       Response response =  given().log().all()
                .queryParam("first_name","first")
                .header("accept",ContentType.XML)
                .auth()
                .oauth2("V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo")
                .when().log().all()
                .get("/public-api/users");
       System.out.println("Status code :"+response.getStatusCode());
       System.out.println("XML Response :"+response.body().asString());
       XmlPath xmlPath = response.body().xmlPath();
       System.out.println("Parse xml response"+xmlPath.get("response._meta.rateLimit.remaining"));

    }
}
