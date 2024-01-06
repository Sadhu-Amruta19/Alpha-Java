public class WordBreking {
    
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
        public static boolean wordbreak(String key){
            if(key.length() == 0){
                return true;
            }
            for(int i=1;i<=key.length();i++){   // loop started with 1 because substring does not take last bound in substring
                if(search(key.substring(0, i)) && wordbreak(key.substring(i)))  //if search returns true then only check for another substring
                {
                    return true;  // substring(i)--> means remainnig string.

                }
            }
            return false;
        }
    
        public static void main(String[] args) {
            String words[] = {"i","like","sam","samsung","mobile","ice"};
            String key = "ilikesamsung";
            for(int i=0;i<words.length;i++){  // make trie
                insert(words[i]);
            }
            System.out.println(wordbreak(key));    
         
            
        }
    
    
    
    
}
