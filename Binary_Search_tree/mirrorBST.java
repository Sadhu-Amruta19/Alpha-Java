public class mirrorBST {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;

        }
    }
    public static Node mirrorBST(Node root){
        if(root == null){
            return null;
        }
        Node lsubtree = mirrorBST(root.left);
        Node rsubtree = mirrorBST(root.right);
        root.left = rsubtree;
        root.right = lsubtree;
        return root;

    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        // Node root = new Node(8);
        // root.left = new Node(5);
        // root.left.left = new Node(3);
        // root.left.right = new Node(6);
        // root.right = new Node(10);
        // root.right.right = new Node(11);

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        mirrorBST(root);
        preorder(root);
    }
}
