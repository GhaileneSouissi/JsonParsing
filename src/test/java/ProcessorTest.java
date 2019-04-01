import CoreProject.JsonLoader;
import CoreProject.Processor;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;

public class ProcessorTest {
    String pathjson = "C:\\Users\\ghailenes\\Desktop\\exercice\\liste_noms_age.json";
    LinkedHashMap<String,Integer> users = JsonLoader.LoadJson(pathjson);

    @Test
    public void theOldestTest(){
        String theOldest = Processor.theOldest(users);
        System.out.println("the oldest is : "+theOldest);
        assertEquals("Olivier",theOldest);
    }
    @Test
    public void theYoungestTest(){
        String theYougest = Processor.theYoungest(users);
        System.out.println("the youngest is : "+theYougest);
        assertEquals("Jean",theYougest);
    }
    @Test
    public void theLongestTest(){
        String theLognest = Processor.theLongestName(users);
        System.out.println("the longest name is :" +theLognest);
        assertEquals("Ghailene",theLognest);

    }
    @Test
    public void theShortestTest(){
        String theShortest = Processor.theShortestName(users);
        System.out.println("the shortest name is : "+theShortest);
        assertEquals("Jean",theShortest);
    }
    @Test
    public void meanTest(){
        double mean = Processor.mean(users);
        System.out.println("the age's average is "+mean);
        assertEquals(35.0,mean,0.001);
    }
    @Test
    public void diffTest(){
        int diff = Processor.diff(users);
        System.out.println("the maximum consecutive difference between ages is : "+diff);
        assertEquals(60,diff);
    }
}
