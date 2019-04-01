package CoreProject;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Properties;

/***
 * A main class to execute the program
 */
public class Main {
    //Logger configuration
    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        //defining properties
        Properties prop = new Properties();
        InputStream input = null;
        //the json file path
        String pathjson = null;
        //the xml file path
        String pathxml = null;
        try{
            //loading the application.properties
            input = Main.class.getClassLoader().getResourceAsStream("application.properties");
            prop.load(input);

            //extracting properties
            pathjson = prop.getProperty("path.json");
            pathxml = prop.getProperty("path.xml");

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            //close file
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //Maps that contains users information
        LinkedHashMap<String,Integer> users = JsonLoader.LoadJson(pathjson);
        LinkedHashMap<String,Integer> usersXML = XMLLoader.LoadXML(pathxml);

        //Processing the files.
        String oldest = Processor.theOldest(users);
        String youngest = Processor.theYoungest(users);
        String longest = Processor.theLongestName(users);
        String shortest = Processor.theShortestName(users);
        double mean = Processor.mean(users);
        int diff = Processor.diff(users);


        logger.debug("the oldest is : "+oldest+" : "+users.get(oldest));
        logger.debug("the youngest is : "+youngest+" : "+users.get(youngest));
        logger.debug("the longest name is : "+longest+" : "+users.get(longest));
        logger.debug("the shortest name is : "+shortest+" : "+users.get(shortest));
        logger.debug("the age's average is "+mean);
        logger.debug("the maximum consecutive difference between ages is : "+diff);

    }
}