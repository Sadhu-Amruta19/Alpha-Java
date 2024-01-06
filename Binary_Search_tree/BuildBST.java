public class BuildBST{
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            

        }
    } 
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        // left subtree
        if(root.data>key){
            return search(root.left,key);
        }
        else{
            return search(root.right,key);
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
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);

    }
    public static void printInRange(Node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            //go left and right both side.
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data<k1){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
    }
    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        
        Node root = null;
        
        for(int i=0;i<values.length;i++){
            root = insert(root,values[i]);
        }
        inOrder(root);
        System.out.println();
        printInRange(root, 5, 12);
        // if(search(root,4)){
        //     System.out.println("found!!");
        // }
        // else{
        //     System.out.println("not found!!");
        // }
    }
}
