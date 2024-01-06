public class DetectCycleLL_1 {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static Node head;
    public static boolean isCycle()
    {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;   // +1
            fast = fast.next.next;  //+2
            if(slow==fast){   // cycle condition
                
                return true;
            }
        }
        return false;   // cycle not detected
        
    }
    public static void main(String[] args) {
        head = new Node(1);
        Node temp = new Node(2);   // need to store in temp so we can detect cycle.
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next = new Node(4);
        //head.next.next.next = temp;
        //1->2->3->4->2
        System.out.println(isCycle());
        
    }
}
