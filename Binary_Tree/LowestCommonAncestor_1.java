import java.util.*;
public class LowestCommonAncestor_1 {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;

        }
    }
    static boolean getpath(Node root,int n,ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return true;
        }
        boolean foundleft = getpath(root.left,n,path);
        boolean foundright = getpath(root.right,n,path);
        if(foundleft || foundright){
            return true;
        }
        path.remove(path.size()-1);
        return false;

    }
    public static Node findLowestAncestor(Node root,int n1,int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getpath(root,n1,path1);
        getpath(root,n2,path2);
        int i=0;
        for(i=0;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        Node lcm = path1.get(i-1);
        return lcm;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(findLowestAncestor(root, 4, 6).data);
    }
}