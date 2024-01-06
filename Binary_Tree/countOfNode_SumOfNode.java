public class countOfNode_SumOfNode {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;

        }
    }
    public static int countNode(Node root){
        if(root==null){  //base case
            return 0;
        }
        int lcount = countNode(root.left);   // count left subchild
        int rcount = countNode(root.right);   //for right sub child
        return lcount+rcount+1;
    }
    public static int sumOfNode(Node root){
        if(root==null){
            return 0;
        }
        int lsum = sumOfNode(root.left);
        int rsum = sumOfNode(root.right);
        return lsum+rsum+root.data;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right= new Node(7);
        System.out.println(sumOfNode(root));
    }
}
