package pojoToJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import jsonToPOJO.Student;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class SerializationExample {

    @Test
    public void marshelling() throws  Exception{
        Student student = new Student(1, "love","97298936");
        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(student);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(string);
        System.out.print(jsonObject);
        System.out.print(jsonObject.get("mobileNumber"));
    }
}
