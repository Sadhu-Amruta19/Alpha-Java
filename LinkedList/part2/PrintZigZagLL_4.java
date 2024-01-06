import java.util.LinkedList;

public class PrintZigZagLL_4{
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static Node head;
    public static void zigzag(Node head){
        // mid
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse half part of LL
        Node curr = mid.next;
        mid.next= null;
        Node prev = null;
        Node next;
        
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        
        //merge zigzag LL
        Node left = head;
        Node right = prev;
        Node nextL;
        Node nextR;
        while(left!=null && right!=null){   // zigzag step
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            // update head
            right = nextR;
            left = nextL;
        }

    }
    

    public static void print(){
        if(head==null){
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        // LinkedList ll = new LinkedList();
        // ll.add(5);
        // ll.add(4);
        // ll.add(3);
        // ll.add(2);
        // ll.add(1);
       
        // ll.addFirst(5);
        // ll.addFirst(4);
        // ll.addFirst(3);
        // ll.addFirst(2);
        // ll.addFirst(1);
        // System.out.print(ll+" ");
        // // head = ll;
        // zigzag(ll);
        // System.out.print(ll+" ");
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        print();
        zigzag(head);

        print();
       
        
    }
}