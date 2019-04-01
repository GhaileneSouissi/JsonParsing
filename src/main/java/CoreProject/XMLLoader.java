package CoreProject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.LinkedHashMap;

/***
 * The Xml Loader , it Loads the Xml file
 */
public class XMLLoader {
    /***
     * convert the Xml file to a map
     * @param xmlFile
     * @return
     */
    public static LinkedHashMap<String,Integer> LoadXML(String xmlFile)  {
        //a linked Map , to keep the order of the elements of the Xml file
        LinkedHashMap users = new LinkedHashMap<String,Integer>();
        //Parsing the Xml file
        Document xml = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            xml = db.parse(xmlFile);
        }catch(Exception e){
            e.printStackTrace();
        }
        //A list tha contains all the nodes under person
        NodeList nList = xml.getElementsByTagName("person");
        //loop the list to extract the name and the age of the person
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                String age = eElement.getElementsByTagName("age").item(0).getTextContent();

                users.put(name,Integer.parseInt(age));

            }
        }

        return users;
    }


}
