public class ReverseDoublyLL_6 {
    static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    static Node head;
    static Node tail;
    int  size;
    // addFirst
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){   // first time new node added
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    // removeFirst
    public int removeFirst(){
        if(head == null){
            System.out.println("Head is empty");
            return Integer.MAX_VALUE;
        }
        if(size==1){
            int val = head.data;
            head = head.next;
            head.prev = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;

    }
    public void reverse(){
        Node curr =head;
        Node temp = null;
        // Node next;
        // while(curr!=null){
        //     next = curr.next;
        //     curr.next = prev;
        //     curr.prev = next;
        //     prev = curr;
        //     curr = next;
        // }
        // head = prev;

        while(curr!=null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;

        }
        if(temp!=null){
            head = temp.prev;
        }
    }
    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");

    }
    public static void main(String[] args) {
        ReverseDoublyLL_6 dll = new ReverseDoublyLL_6();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(6);
        dll.print();
        dll.reverse();
        dll.print();
        
    }
}
