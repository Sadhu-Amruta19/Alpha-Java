import java.util.LinkedList;

public class MergeSortInLL_3 {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static Node head;
    private static Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next; // slow+1
            fast=fast.next.next; //fast+2
        }
        return slow;  // mid point

    }
    public static Node merge(Node head1,Node head2){
        Node mergeLL = new Node(-1);   // extra linkedlist
        Node temp = mergeLL;  // head of extra ll
        while(head1!=null && head2!=null){
            // compair h1 and h2
            if(head1.data<=head2.data){  //  if h1 small
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{   // if h2 small
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1!=null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;

        }
        while(head2!=null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        
        return mergeLL.next;

    }
    public  static Node mergeSort(Node head){
        // base case
        if(head==null || head.next==null){
            
            return head;
        }
        // find mid
        Node mid = getMid(head);

        // division
        Node rightHead = mid.next;
        mid.next=null;
        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);

        // merge

        return merge(left,right);
    }
    public static void print(Node head){
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
        // ll.addFirst(1);
        // print();
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.addFirst(5);
        // LinkedList<Integer> ll = new LinkedList<>();
        // ll.add(1);
        // ll.add(2);
        // ll.add(3);
        // ll.add(4);
        // ll.add(5);
        // int start = ll.getFirst();
        // System.out.println(start);

        head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        print(head);    
        head = mergeSort(head);
        print(head);        
        //System.out.println(head.data);
        // System.out.println();
    }
}
