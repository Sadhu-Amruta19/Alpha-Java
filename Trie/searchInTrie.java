public class searchInTrie {
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

    public static boolean search(String key){
        Node curr = root;
        
        for(int level=0;level<key.length();level++){
            int idx = key.charAt(level)-'a';  // got index in children array
            
            if(curr.children[idx]==null){
                return false;  // means not found.
            }
            curr = curr.children[idx];   // value of curr updated
            
        }
        return curr.eow = true;
    }

    public static void main(String[] args) {
        String words[] = {"the","a","there","their","any","thee"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        
            System.out.println(search("thee"));
            System.out.println(search("thor"));
        
    }
}

