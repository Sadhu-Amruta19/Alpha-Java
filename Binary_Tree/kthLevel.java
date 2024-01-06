import javax.security.auth.kerberos.KerberosCredMessage;

public class kthLevel {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }
    public static void kLevel(Node root,int level,int k){
        if(root==null){
            return;
        }
        if(level==k){
            System.out.print(root.data+" ");
        }
        kLevel(root.left,level+1,k);
        kLevel(root.right,level+1,k);

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        kLevel(root,1,3);

    }
}
