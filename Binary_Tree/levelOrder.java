import java.util.*;
public class levelOrder {
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
        public void levelorder(Node root) {
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode==null){
                    //System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    // else{
                    //     q.add(null);
                    // }
                }
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }

        }
        
    }
        public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTreeC tree = new BinaryTreeC();
        Node root = tree.buildTree(nodes);
        
        tree.levelorder(root);
        
    }

}

