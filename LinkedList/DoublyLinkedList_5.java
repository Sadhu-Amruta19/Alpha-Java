public class DoublyLinkedList_5 {
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
    // addLast
    public void addLast(int data){
        Node newNode = new Node(data);
        size++; 
        if(head == null){
            newNode = tail=head;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
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
        DoublyLinkedList_5 dll = new DoublyLinkedList_5();
        
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(3);
        dll.addLast(4);
        dll.print();
        System.out.println(dll.size);
        
        // dll.removeFirst();  // 3
        // dll.print();
        // System.out.println(dll.size);
        // dll.removeFirst();   // 2
        
        // dll.print();
        // System.out.println(dll.size);
        
       
        
        
    }
}
