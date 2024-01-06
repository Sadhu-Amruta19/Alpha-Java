public class MinDistance {
    
        static class Node{
            int data;
            Node left,right;
            public Node(int data){
                this.data = data;
                this.left = left;
                this.right = right;
    
            }
        }
        public static Node lca2(Node root,int n1,int n2){    // for finding lca.
            if(root==null || root.data ==n1 || root.data==n2){
                return root;
            }
            Node leftLca = lca2(root.left, n1, n2);
            Node rightLca = lca2(root.right, n1, n2);
    
            if(leftLca == null){
                return rightLca;
            }
            if(rightLca == null){
                return leftLca;
            }
            // if(rightLca && leftLca!=null){  //if both not null that mean main root is our ans ex for 4 & 6 =1.
                return root;
            //}
        }
        public static int lcadist(Node root,int n){  // for lca to distance

            if(root==null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }
            int leftdist = lcadist(root.left,n);
            int rightdist = lcadist(root.right,n);
            if(leftdist==-1){
                return rightdist+1;
            }
            else if(leftdist==-1 && rightdist==-1){
                return -1;
            }
            else{
                return leftdist+1;
            }
        }
        public static int minDist(Node root,int n1,int n2){  //final answer given.
            Node lca = lca2(root,n1,n2);
            int dist1 = lcadist(lca,n1);
            int dist2 = lcadist(lca,n2);
            return dist1 + dist2; 

        }
        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right = new Node(3);
            root.right.left = new Node(6);
            root.right.right = new Node(7);
            System.out.println(minDist(root, 4,5));
        }
    }
    
