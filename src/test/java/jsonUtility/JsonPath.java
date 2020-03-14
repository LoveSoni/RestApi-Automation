package jsonUtility;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class JsonPath {

    @Test
     public void parseJson(){
          FileReader fileReader = null;
          final String SLASH = File.separator;
          try {
              fileReader = new FileReader("");
          }catch (FileNotFoundException e){
              e.printStackTrace();
          }
         JSONParser jsonParser = new JSONParser();
          JSONObject jsonObject = null;
          try {
            jsonObject =  (JSONObject)jsonParser.parse(fileReader);
          }catch (Exception e){
              e.printStackTrace();
          }
          extractJson(jsonObject,"data.formFields[1].docTitle");
     }

     public void extractJson(JSONObject jsonObject,String query){
        System.out.println(jsonObject.toJSONString());
         System.out.print(query.toString());
         System.out.println("Parse xml response"+ com.jayway.jsonpath.JsonPath.read(jsonObject,query));
     }
}
