import java.util.*;
public class RootToLeaf {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            

        }
    } 
    public static Node insert(Node root,int val){ // passed only value becoz one by one value will pass not whole array at a time.
        if(root==null){
            root = new Node(val);

            return root;
        }
        if(root.data > val){
            

            root.left=insert(root.left,val);
        }else{
            root.right = insert(root.right,val);
        }
      
        return root;
    }
    static void printpath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+" -> ");
        }
        System.out.println("Null");
    }
    public static void root2leafpath(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){  // leaf node
            printpath(path);
        }
        root2leafpath(root.left, path);
        root2leafpath(root.right, path);
        path.remove(path.size()-1);

    }
    public static void main(String[] args) {
        int values[] = {8,5,3,6,10,11};
        
        Node root = null;
        
        for(int i=0;i<values.length;i++){
            root = insert(root,values[i]);
        }
        root2leafpath(root, new ArrayList<>()); // pass arraylist as new arraylist
    }
}
