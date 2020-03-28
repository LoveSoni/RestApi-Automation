package jsonToPOJO;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;

public class DeserializationTest {

    @Test
    public void unmarshelling() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonFilePath = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"jsonToPOJO"+File.separator+"jsonFile.json";
        Student student = objectMapper.readValue(new File(jsonFilePath),Student.class);
        System.out.print(student);
    }
}
