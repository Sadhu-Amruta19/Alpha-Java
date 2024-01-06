import java.util.*;
public class IterationHashSet {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Surat");
        cities.add("Vadodara");
        cities.add("Ahemdabad");
        cities.add("Mahesana");

        // Iterator it = cities.Iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }

        // method 2
        for(String city : cities){
            System.out.println(city);
        }

        
    }
}
