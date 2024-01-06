public class SubtreeOfAnotherTree {
        static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;

        }
    }

    public static boolean isIdentical(Node node, Node subroot){
        if(node==null && subroot == null){
            return true;
        }else if(node==null || subroot == null || node.data != subroot.data){  // null and datamatch cases
            return false;
        }
        if(!isIdentical(node.left, subroot.left)){   // left and right data matches
            return false;
        }
        if(!isIdentical(node.right, subroot.right)){
            return false;
        }
        return true;
    
}
    public static  boolean isSubtree(Node root,Node subroot){
        if(root==null){
            return false;
        }
        if(root.data==subroot.data){    // checks it 1st root of subtree is matched with main tree or not
            if(isIdentical(root,subroot)){

                return true;   // if matched send true flag to isidentical.
            }
        }

        return isSubtree(root.left,subroot) || isSubtree(root.right, subroot);

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right= new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

         Node subroot = new Node(3);
        //  subroot.left = new Node(6);
         subroot.right = new Node(6);
         System.out.println(isSubtree(root,subroot));
        

        
    }
}


