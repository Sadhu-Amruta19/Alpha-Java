import java.util.*;
public class TopviewOfTree {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;

        }
    }
    static class Info{
        Node node;
        int hd;
        public Info(Node node,int hd){   // made object for storing  multiple value..
            this.node = node;
            this.hd = hd;
        }

    }
    public static void topview(Node root){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        int min=0,max=0;
        q.add(new Info(root,0));
        q.add(null);
        // Level order steps
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(!map.containsKey(curr.hd)){  // first time my horizontal distance is occuring
                    map.put(curr.hd, curr.node);  // horizontal distance and current node stored in map.
                }
                if(curr.node.left!=null){
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new Info(curr.node.right,curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }
            }
        }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }


    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        topview(root);
    }
}
