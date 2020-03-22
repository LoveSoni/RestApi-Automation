package httpClient;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class BasicAuth {

    // like in rest assured we can automate the basic auth api like
    //RequestSpecification request = RestAssured.given()
    // request.auth().basic("username","password");
    @Test
    public void hit() throws Exception{
        String baesUri = "";
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(new AuthScope("http://httpbin.org/",80),new UsernamePasswordCredentials("user","passwd"));
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCredentialsProvider(credentialsProvider).build();
        HttpGet httpGet = new HttpGet("http://httpbin.org/basic-auth/user/passwd");
        HttpResponse httpResponse = httpClient.execute(httpGet);
        System.out.println(EntityUtils.toString(httpResponse.getEntity()));
    }
}
