package getApis;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class GetBDDApi {
    @Test
    public void getApiTest(){
        given().log().all()
                .when().log().all()
                .get("https://reqres.in/api/users?page=2")
                .then().log().all()
                .assertThat()
                .body("data.id",hasSize(6));
    }

    @Test
    public void getApiTest2(){
       Response response = given()
                .when()
                .get("https://reqres.in/api/users?page=2");
        int statusCode = response.getStatusCode();
        System.out.println("Status code :"+statusCode);
        Assert.assertEquals(statusCode,200);
        System.out.println("List of Response headers :"+response.getHeaders());
        System.out.println("Response body : "+ response.prettyPrint());
    }

    @Test
    public void getApiTest3(){
        baseURI = "http://ergast.com";
        Response response = given()
                .when()
                .get("/api/f1/2017/circuits.json");
        int statusCode = response.getStatusCode();
        System.out.println("Status code :"+statusCode);
        System.out.println("Respnse body :"+response.prettyPrint());
    }

    @Test
    public void getApiTest4(){
        baseURI = "http://ergast.com";
        given()
                .when()
                .get("/api/f1/2017/circuits.json")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and()
                .header("content-type","application/json; charset=utf-8")
                .and()
                .body("MRData.limit",equalTo("30"));
    }

    @Test
    public void queryParameterExample(){
        baseURI = "https://reqres.in";
        given().log().all()
                .param("page","2").log().all()
                .when().log().all()
                .get("/api/users")
                .then().log().all()
        .body("data[0].email",equalTo("michael.lawson@reqres.in"));
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] testData = {
                {"page1",1},
                {"page2",2},
                {"page3",3},
                {"page4",4},
                {"page5",5}
        };
        return testData;
    }

    @Test(dataProvider ="getData")
    public void useDataProvider(String pageNumber,int page){
        baseURI = "https://reqres.in";
        given().log().all()
                .param("page",page).log().all()
                .when().log().all()
                .get("/api/users")
                .then().log().all()
                .assertThat()
                .body("page",equalTo(page));
    }
}

