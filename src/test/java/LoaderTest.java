import CoreProject.JsonLoader;
import CoreProject.XMLLoader;
import org.junit.Before;
import org.junit.Test;
import java.util.LinkedHashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/***
 * A Loader Test , to make sure that the Json/XML is fully Loaded
 */
public class LoaderTest {

    private LinkedHashMap<String,Integer> usersJson = new LinkedHashMap<>();
    private  LinkedHashMap<String,Integer> usersXml = new LinkedHashMap<>();
    @Before
    public void LoadJsonXML(){
        String pathjson = "C:\\Users\\ghailenes\\Desktop\\exercice\\liste_noms_age.json";
        String pathxml = "C:\\Users\\ghailenes\\Desktop\\exercice\\liste_noms_age.xml";
        usersJson = JsonLoader.LoadJson(pathjson);
        usersXml = XMLLoader.LoadXML(pathxml);
    }
    /***
     * Json Loader Test , it makes sure that the map users is not empty and fully loaded
     */
    @Test
    public void JsonLoaderTest(){
        assertNotNull(usersJson);
        assertEquals(10,usersJson.size());

    }

    /***
     * Xml Loader Test, it makes sure that the map users is not empty and fully loaded
     */
    @Test
    public void XMLLoaderTest(){
        assertNotNull(usersXml);
        assertEquals(10,usersXml.size());

    }
}
