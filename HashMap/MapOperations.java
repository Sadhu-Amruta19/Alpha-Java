import java.util.*;
public class MapOperations{
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        // insert data
        hm.put("china",150);
        hm.put("Us",50);
        hm.put("India",100);
        System.out.println(hm);

        // get
        System.out.println(hm.get("India"));

        // ContainsKey
        System.out.println(hm.containsKey("Indonesia"));
        System.out.println(hm.containsKey("India"));

        // remove
        System.out.println(hm.remove("china"));  // remove data with print key value.
        
        System.out.println(hm);

        // size
        System.out.println(hm.size());

        // isEmpty
        hm.clear();  // remove all data from map.
        System.out.println(hm.isEmpty());
    }


}