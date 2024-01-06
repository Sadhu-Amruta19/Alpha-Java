public class TransformToSum {

  
    
        static class Node{
            int data;
            Node left,right;
            public Node(int data){
                this.data = data;
                this.left = left;
                this.right = right;
    
            }
        }

        public static int transformSum(Node root){
            if(root==null){
                return 0;
            }
            int leftchild = transformSum(root.left);
            int rightchild = transformSum(root.right);
            int data = root.data;
            int newleftroot = root.left == null ? 0 :root.left.data;
            int newrightroot = root.right == null ? 0 :root.right.data;
            root.data = leftchild+newleftroot+rightchild+newrightroot;
            return data;

        }
        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
            
        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right = new Node(3);
            root.right.left = new Node(6);
            root.right.right = new Node(7);

            transformSum(root);
            preorder(root);
        }
    }
    




