import java.util.*;
public class InterationHashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India",150);
        hm.put("china",100);
        hm.put("US",50);
        hm.put("UK",20);

        // Iteration
        // Set<String> keys = hm.keySet();
        // System.out.println(keys);  // only print keys.

        // for (String k : keys) {
        //     System.out.println("Key is: "+k +" ,Value is: "+hm.get(k));
            
        // }
        System.out.println(hm);
    }
}
