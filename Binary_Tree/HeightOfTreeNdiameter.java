public class HeightOfTreeNdiameter {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;

        }
    }
    public static int height(Node root){
        if(root==null){   //base case
            return 0;
        }
        int lh = height(root.left);   // left child count individual
        int rh = height(root.right);  // all right child call recursively individual
        return Math.max(lh,rh)+1;
    }
    public static int diameter(Node root){
        if(root==null){   //base case
            return 0;
        }
        int ldiam,rdiam,lh,rh;
        int selfdiam;
        ldiam=diameter(root.left);
        rdiam=diameter(root.right);
        lh=height(root.left);
        rh=height(root.right);
        selfdiam = lh+rh+1;
        return Math.max(selfdiam,Math.max(ldiam,rdiam));  // first finding max between ldiam and rdiam
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right= new Node(7);
        System.out.println(diameter(root));
    }
}
