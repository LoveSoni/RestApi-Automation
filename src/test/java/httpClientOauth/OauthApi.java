package httpClientOauth;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class OauthApi {
    @Test
    public void hit() throws  Exception{
        String consumerKey = "";
        String consumerSecret = "";
        String accessToken = "";
        String accessTokenSecret = "";
        OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKey,consumerSecret);
        oAuthConsumer.setTokenWithSecret(accessToken,accessToken);
        CloseableHttpClient httpClient =HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("");
        oAuthConsumer.sign(httpPost);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        System.out.println("Response is :"+EntityUtils.toString(httpResponse.getEntity()));
    }
}
