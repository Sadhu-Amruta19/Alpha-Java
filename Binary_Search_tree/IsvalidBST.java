public class IsvalidBST {
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
    public static Boolean IsValidBST(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){  // for right side
            return false;
        }
        else if(max!=null && root.data>=max.data){   // left side
            return false;
        }
        return IsValidBST(root.left, min, root) && IsValidBST(root.right, root, max);

    }
    public static void main(String[] args) {
        int values[] = {5,3,1,4,6,7};
        
        Node root = null;
        
        for(int i=0;i<values.length;i++){
            root = insert(root,values[i]);
        }
        
        if(IsValidBST(root, null, null)){
            System.out.println("valid!");
        }
        else{
            System.out.println("Is not valid!!");
        }
    }
}
