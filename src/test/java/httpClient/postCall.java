package httpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;

public class postCall {

    @Test
    public void hit() throws Exception{
        String newUserUrl = "https://gorest.co.in/public-api/users";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(newUserUrl);
        FileReader fileReader = new FileReader(System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"httpClient"+File.separator+"userRequest.json");
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
        System.out.println(jsonObject.toJSONString());
        httpPost.addHeader("Authorization","Bearer V32Ni9QvrY9oCVjmFl1u7ALvOwimZTKwAzbo");
        httpPost.addHeader("content-type","application/json");
        httpPost.setEntity(new StringEntity(jsonObject.toString()));
        HttpResponse httpResponse = httpClient.execute(httpPost);
        System.out.println(EntityUtils.toString(httpResponse.getEntity()));
    }
}
