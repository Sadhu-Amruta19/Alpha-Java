import java.util.*;
public class ItineraryTickets {
    public static String getStart(HashMap<String,String> tickets){
        HashMap<String,String> revmap = new HashMap<>();
        // add all data of original hashmap in reverse order.
        for(String key : tickets.keySet()){
            revmap.put(tickets.get(key),key);
        }
       
        // find start string from map.
        for(String key : tickets.keySet()){  // hash map inbuilt method

            if(!revmap.containsKey(key)){
                
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai","Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");

        String start = getStart(tickets);  // Mumbai first time stored...
        System.out.print(start);
        for(String key : tickets.keySet()){
            System.out.print(" -->"+tickets.get(start));  //  Mumbai --> Delhi
            start = tickets.get(start);
        }


    }
}
