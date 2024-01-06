import java.util.*;
public class AVLTrees {
    static class Node{
        int data,height;
        Node left,right;
        public Node(int data){
            this.data=data;
            height = 1;
        }
        
    }
    public static Node root;
    public static int height(Node root){
        if(root== null){
            return 0;
        }
        return root.height;
    }
    public static int getbalance(Node root){
        if(root==null){
            return 0;
        }
        return height(root.left)-height(root.right);
    }
    public static Node insert(Node root,int key){
        if(root == null){  // root insert
            return new Node(key);
        }
        if(root.data>key){  // leftsubtree
            root.left=insert(root.left, key);
        }
        else if(root.data<key){ // right subtree
            root.right=insert(root.right, key);
        }
        else{    // root.data and key both same so only return root duplicate not allow.
            return root;  
        }
        root.height = 1+Math.max(height(root.left),height(root.right));
        //get root's balanced factor
        int bf = getbalance(root);
        // all cases conditions
        //1.L-L case:
        if(bf>1 && key<root.left.data){
            return rightRotate(root);
        }
        //2.L-R case:
        if(bf>1 && key>root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        //1.R-R case:
        if(bf<-1 && key>root.left.data){
            return leftRotate(root);
        }
        //1.R-L case:
        if(bf<-1 && key<root.right.data){
            return leftRotate(root);
        }
        return root;  // ifalready in AVL form.
    }
    public static Node leftRotate(Node x){
        Node y = x.right;
        Node T2= y.left;
        //perform rotation
        y.left = x;
        x.right = T2;
        //update heights
        x.height = Math.max(height(x.left),height(x.right)+1);
        y.height = Math.max(height(y.left),height(y.right)+1);

        //return new node
        return y;

    }
   
    public static Node rightRotate(Node y){
        Node x = y.left;
        Node T2= x.right;
        //perform rotation
        x.right = y;
        y.left = T2;
        //update heights
        x.height = Math.max(height(x.left),height(x.right)+1);
        y.height = Math.max(height(y.left),height(y.right)+1);

        //return new node
        return x;

    }


    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        root = insert(root,40);
        root = insert(root,20);
        root = insert(root,10);
        root = insert(root,25);
        root = insert(root,30);
        root = insert(root,22);
        preOrder(root);

    }
}
