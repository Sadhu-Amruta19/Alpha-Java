import java.util.*;
public class Valid_Anagram {
    public static boolean isValidAnagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        // put s in map
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        // it's time for t
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(map.get(ch)!=null){  // valid character got
                if(map.get(ch)==1){    // frequency of character is one
                    map.remove(ch);   // decreses frequency val gone 0 that's why remove that char
                }
                else{
                    map.put(ch, map.get(ch)-1);  //frequency --
                }
            }
            else{
                return false;
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        String s = "RACE";
        String t = "CARE";
        System.out.println(isValidAnagram(s,t));
    }
}
