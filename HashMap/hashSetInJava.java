import java.util.*;
public class hashSetInJava { // HashSet
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(2);
        System.out.print(set);
        System.out.println(set.size());
        set.clear();
        set.isEmpty();

        if(set.contains(2)){
            System.out.println("set contains! Duplicate Not allowed");
        }


        
    }

    public void put(int i) {
    }

    public void clear() {
    }

    public void add(int i) {
    }

    public boolean contains(int i) {
        return false;
    }

    public void remove(int i) {
    }

    public String size() {
        return null;
    }
}
