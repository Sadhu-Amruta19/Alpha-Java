public class BuildTree{
    
        static class Node{
            int data;
            Node left;
            Node right;
            Node(int data){
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }
        static class BinaryTreeC{
            static int idx = -1;
            public static Node buildTree(int nodes[]){
                idx++;
    
                if(nodes[idx]==-1){
                    return null;
                }
                Node newNode = new Node(nodes[idx]); // first element is root
                newNode.left = buildTree(nodes);  //bases of root left
                
                newNode.right = buildTree(nodes);//bases of root right
    
                return newNode;
    
            }
            // public void preOrder(BuildTree.Node root) {
            // }
            public static void preOrder(Node root){
                if(root==null){
                    System.out.print("-1"+" ");
                    return;
                }
                System.out.print(root.data+" ");
                preOrder(root.left);
                preOrder(root.right);
            }
            public static void inOrder(Node root){
                if(root==null){
                    // System.out.print("-1"+" ");
                    return;
                }
                inOrder(root.left);
                System.out.print(root.data+" ");
                inOrder(root.right);
            }
            public static void postOrder(Node root){
                if(root==null){
                    // System.out.print("-1"+" ");
                    return;
                }
                postOrder(root.left);
                postOrder(root.right);
                System.out.print(root.data+" ");
            }
        }
            public static void main(String[] args) {
            int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            BinaryTreeC tree = new BinaryTreeC();
            Node root = tree.buildTree(nodes);
            
            tree.postOrder(root);
            
        }
    
}