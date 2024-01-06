// find given prefix in arr[] exist or not
public class StartsWith_5 {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;  // end of word.

        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }

    }
    static Node root = new Node();
    public static void insert(String word){
        Node curr = root;
        
        for(int level=0;level<word.length();level++){
            int idx = word.charAt(level)-'a';  // got index in children array
            
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();  // curr children updated
            }
            curr = curr.children[idx];   // value of curr updated
            
        }
        curr.eow = true;
    }
    public static boolean startsWith(String prefix){
        Node curr = root;
        for(int i=0;i<prefix.length();i++){
            int idx = prefix.charAt(i)-'a';
            if(curr.children[idx]==null){   // if root na children ma value find na thay to false..
                return false;
            }
            curr = curr.children[idx];  // curr nu children have current..
        }
        return true;  // after traverse whole prefix if found all in children array return true..
    }
    public static void main(String[] args) {
        String arr[] = {"apple","app","mango","man","woman"};
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        System.out.println(startsWith("app"));
        System.out.println(startsWith("moon"));
        
    }
}
