public class LongestWordWithPrefix_7 {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
        
    }
    public static Node root = new Node();
    public static void insert(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();

            }
            curr = curr.children[idx];

        }
        curr.eow = true;

    }
    public static String ans = "";
    public static void longestWord(Node root,StringBuilder temp){
        // base case
        if(root==null){
            return;
        }
        // compair all prefix of word with root,root.children,children of children...
        for(int i=0;i<26;i++){   // if we reverse this loop than get "apply" as ans.
            if(root.children[i]!=null && root.children[i].eow==true){
                char ch = (char)(i+'a');   // convert ith index in character  0th index 0+'a' = a
                temp.append(ch);  // join all ans string
                if(temp.length() > ans.length()){ // final ans less than temp than only add value in final ans
                    ans = temp.toString();   // fron stringbuilder add value in string using toString method.
                }  
                    

                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);  // backtracking
            }
        }
    }

    public static void main(String[] args) {
        String words[] = {"a","banana","app","appl","ap","apply","apple"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);  // create trie tree
        }
        longestWord(root, new StringBuilder(""));
        if(ans==""){
            System.out.println("doesn't exist any string");
        }
        System.out.println(ans);
        
    }
}
