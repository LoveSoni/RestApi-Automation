package httpClient;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import sun.net.www.http.HttpClient;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

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
        httpGet.addHeader("Authorization","Bearer V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo");
        HttpResponse response = httpClient.execute(httpGet);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
