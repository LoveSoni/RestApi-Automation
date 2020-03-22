package httpClientOauth;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class OauthApi {
    @Test
    public void hit() throws  Exception{
        String consumerKey = "HGgqWV2t6YnEhhBvuDnAcYlli";
        String consumerSecret = "LTqWrkWEkcW7FsZO93gq1Z9IfnED8LSY4cpCBAiQGY8AXrLloQ";
        String accessToken = "220976784-2eQZmLlaEPxeNb3Wywy24dXldUlq1ge29afKA2AR";
        String accessTokenSecret = "SgXmzqweFoaSilrWLCwYXCYKme4Rk8oXlK4rtE1CUrJN7";
        OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKey,consumerSecret);
        oAuthConsumer.setTokenWithSecret(accessToken,accessToken);
        CloseableHttpClient httpClient =HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://api.twitter.com/1.1/statuses/update.json?status=Naveen");
        oAuthConsumer.sign(httpPost);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        System.out.println("Response is :"+EntityUtils.toString(httpResponse.getEntity()));
    }
}
