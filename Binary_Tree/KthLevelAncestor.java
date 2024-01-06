import java.util.*;
public class KthLevelAncestor {
  
    
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;

        }
    }

    public static int kthAncestor(Node root,int n,int k){
        if(root==null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftdist = kthAncestor(root.left, n, k);
        int rightdist = kthAncestor(root.right, n, k);
        if(leftdist==-1 && rightdist==-1){
            return -1;
        }
        int max = Math.max(leftdist,rightdist);
        if((max+1) == k){
            System.out.println(root.data);  // printing that element where k matches
        }
        return max+1;  // count of kthLevelAncestor. // here for this is:2
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        kthAncestor(root, 5,2);
    }
}
    


