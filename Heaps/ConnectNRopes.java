import java.util.*;
public class ConnectNRopes {
    public static void main(String[] args) {
        int ropes[] = {4,3,2,6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<ropes.length;i++){ // need to add data in priorityQ.
            pq.add(ropes[i]);
        }
        int count = 0;
        while(pq.size()>1){
            int min = pq.remove();
            int min2 = pq.remove();
            count+=min+min2;
            pq.add(min+min2);
        }
        System.out.println("Count of connect N ropes: "+count);
        
    }
    
}
