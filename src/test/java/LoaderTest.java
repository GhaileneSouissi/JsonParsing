import CoreProject.JsonLoader;
import CoreProject.XMLLoader;
import org.junit.Test;
import java.util.LinkedHashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/***
 * A Loader Test , to make sure that the Json/XML is fully Loaded
 */
public class LoaderTest {

    String pathjson = "C:\\Users\\ghailenes\\Desktop\\exercice\\liste_noms_age.json";
    String pathxml = "C:\\Users\\ghailenes\\Desktop\\exercice\\liste_noms_age.xml";

    /***
     * Json Loader Test , it makes sure that the map users is not empty and fully loaded
     */
    @Test
    public void JsonLoaderTest(){
        LinkedHashMap<String,Integer> users = JsonLoader.LoadJson(pathjson);

        assertNotNull(users);
        assertEquals(10,users.size());

    }

    /***
     * Xml Loader Test, it makes sure that the map users is not empty and fully loaded
     */
    @Test
    public void XMLLoaderTest(){
        LinkedHashMap<String,Integer> users = XMLLoader.LoadXML(pathxml);

        assertNotNull(users);
        assertEquals(10,users.size());

    }
}
