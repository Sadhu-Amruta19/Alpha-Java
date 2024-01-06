import java.util.*;
public class Merge2BST {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            this.left=right=null;
        }
    }
    public static void getInOrder(Node root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        getInOrder(root.left,arr);
        arr.add(root.data);
        getInOrder(root.right,arr);

    }
    public static Node createBST(ArrayList<Integer> inorder,int st,int end){
        if(st>end){
            return null;
        }
       int mid =  (st+end)/2;
       Node root = new Node(inorder.get(mid));
       root.left = createBST(inorder,st,mid-1);
       root.right = createBST(inorder, mid+1, end);
       return root;
    }
    public static Node Merge2BSts(Node root1,Node root2){
        // step 1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInOrder(root1,arr1);
        // step 2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInOrder(root2,arr2);
        //step 3 : Merge
        int i=0,j=0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
              if(arr1.get(i)<arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }else{
                  finalArr.add(arr2.get(j));
                  j++;
            }
        }
        //step 4   sorted array -> BT
        return createBST(finalArr, 0, finalArr.size()-1);

    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        // tree 1
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.left.right = new Node(4);  
        //tree 2
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.left.right = new Node(12);  
        Node root = Merge2BSts(root1, root2);
        preOrder(root);

        
    }
}
