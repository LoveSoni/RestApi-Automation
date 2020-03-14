package POJO;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class PostWithPojo {
    @Test
    public void pojoTest() throws Exception{
        UserPojo userPojo = new UserPojo("Jim", "Brown", 111, true, new BookingPojo("2018-01-01", "2019-01-01"), "Breakfast");
        ObjectMapper objectMapper = new ObjectMapper();
        String stringRequest = objectMapper.writeValueAsString(userPojo);
        JSONParser jsonParser = new JSONParser();
        JSONObject requestJson = (JSONObject)jsonParser.parse(stringRequest);
        System.out.println(requestJson);
    }
}
