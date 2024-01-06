public class deleteNode {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data=data;
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
    public static Node deleteNode(Node root,int val){
        if(root.data < val){
            root.right = deleteNode(root.right, val);
        }
        else if(root.data > val){
            root.left = deleteNode(root.left, val);
        }
        else{    // root.data== value
            //case  1: Leaf
            if(root.left == null && root.right == null){
                return null;
            } 
            // case 2:One child
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            // case 3: 2 children
            //first find Inorder sucessor
            Node IS = findInOrdersuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right,IS.data); // IS value deleted and replaced with root of right.
        }
        return root;
    }
    public static Node findInOrdersuccessor(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        
            int values[] = {10,20,15,14,13,18,25,21,28};
            
            Node root = null;
            
            for(int i=0;i<values.length;i++){
                root = insert(root,values[i]);
            }
            inOrder(root);
            System.out.println();
            root = deleteNode(root, 15);
            inOrder(root);
    }
}
