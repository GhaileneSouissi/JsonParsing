package CoreProject;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

/***
 * The Json loader , loads json file
 */
public class JsonLoader {
    //Logger configuration
    final static org.apache.log4j.Logger logger = Logger.getLogger(JsonLoader.class);

    /***
     * convert the json file to a map
     * @param path
     * @return
     */
    public static LinkedHashMap<String,Integer> LoadJson(String path){
        //the users map
        LinkedHashMap users = new LinkedHashMap<String,Integer>();
        //the Json Parser
        JSONParser parser = new JSONParser();
        JSONArray usersJson = null;
        try {
            //extracting the users array from the Json
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            usersJson = (JSONArray)jsonObject.get("users");

            //Storing all the information in a map
            for (int i=0;i<usersJson.size();i++) {
                JSONObject user = (JSONObject)usersJson.get(i);
                String name = (String) user.get("name");
                long age = (long) user.get("age");
                users.put(name,(int)age);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return users;
    }
}
