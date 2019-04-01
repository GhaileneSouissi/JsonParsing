package CoreProject;

import java.util.LinkedHashMap;

/***
 * A class to process Json File
 */
public class Processor {
    /***
     * return the oldest person
     * @param users
     * @return
     */
    public static String theOldest(LinkedHashMap<String,Integer> users ) {
       return users.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
    }
    /***
     * return the youngest person
     * @param users
     * @return
     */
    public static String theYoungest(LinkedHashMap<String,Integer> users ){
        return users.entrySet().stream().min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
    }
    /***
     * return the person the longest name
     * @param users
     * @return
     */
    public static String theLongestName (LinkedHashMap<String,Integer> users){
        return users.entrySet().stream().max((entry1,entry2)->entry1.getKey().length()> entry2.getKey().length() ? 1 : -1).get().getKey();
    }
    /***
     * return the person with the shortest name
     * @param users
     * @return
     */
    public static String theShortestName(LinkedHashMap<String,Integer> users){
        return  users.entrySet().stream().min((entry1,entry2)->entry1.getKey().length() > entry2.getKey().length() ? 1 : -1).get().getKey();
    }
    /***
     * return the average age
     * @param users
     * @return
     */
    public static double mean(LinkedHashMap<String,Integer> users){
      int sum = users.entrySet().stream().map(x->x.getValue()).reduce(0,(a,b)->(a+b));
      return sum/users.size();
    }
    /***
     * return the highest difference between two consecutive ages
     * @param users
     * @return
     */
    public static int diff(LinkedHashMap<String,Integer> users){
        int maxdiff = -999;
        int dif=0;
        String key1 = users.entrySet().iterator().next().getKey();
        Integer value1 = users.entrySet().iterator().next().getValue();
        users.remove(key1);

        for(String key : users.keySet()){
            dif = value1 -users.get(key);
            if(dif>maxdiff) maxdiff = dif;
            value1 = users.get(key);
        }

        return maxdiff;

    }
}
