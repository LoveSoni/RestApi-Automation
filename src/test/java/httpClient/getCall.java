package httpClient;


import com.jayway.jsonpath.JsonPath;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;
import java.net.URISyntaxException;

public class getCall {
    @Test
    public void hit() throws Exception{
        String baseUrl = "https://gorest.co.in/public-api/users";
        try {
            URIBuilder uriBuilder = new URIBuilder(baseUrl);
            uriBuilder.addParameter("first_name","first");
            baseUrl = uriBuilder.build().toString();
        }catch (URISyntaxException e)
        {
            e.printStackTrace();
        }
        System.out.println("Base url is :"+baseUrl);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(baseUrl);
        httpGet.addHeader("Authorization","Bearer V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzb");
        JSONParser jsonParser = new JSONParser();
        HttpResponse response = httpClient.execute(httpGet);
        JSONObject jsonObject =(JSONObject)jsonParser.parse(EntityUtils.toString(response.getEntity()));
        System.out.println(JsonPath.read(jsonObject,"result.code"));
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
