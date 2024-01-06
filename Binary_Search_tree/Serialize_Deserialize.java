import java.util.*;
public class Serialize_Deserialize {
    public static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data=data;
        }
    }
    public static void serialize(Node root, ArrayList<Integer> A) 
	{
	    //code here

        // tree to arrayList form
	    if(root==null){
	        return;
	    }
	    serialize(root.left, A);
        A.add(root.data);
        serialize(root.right, A); 
           
	    
	}
    public static Node deSerialize(ArrayList<Integer> A)
    {
        //code here
        // array to tree...
        int st=0;
        int end=A.size()-1;
        Node root=arrayTOTree(A,st,end);
        return root;
        
        
    }
    public static Node arrayTOTree(ArrayList<Integer> A,int st,int end){
        
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(A.get(mid));
        root.left=arrayTOTree(A,st,mid-1);
        root.right=arrayTOTree(A,mid+1,end);
        
        return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        root.right = new Node(30);
        
        ArrayList<Integer> A = new ArrayList<>();
        serialize(root,A);
        root = deSerialize(A);
        
        inorder(root);

    }
}
