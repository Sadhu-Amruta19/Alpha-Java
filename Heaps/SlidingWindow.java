import java.util.*;
public class SlidingWindow {
    public static class Pair implements Comparable<Pair>{

        int val;
        int idx;
        public Pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.val - this.val;
        }
    }
    public static void main(String[] args) {
        int arr[]= {1,3,-1,-3,5,3,6,7};
        
        int n=arr.length;
        int k = 3;
        int res[] = new int[n-k+1];  // no.of silding stored.
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(new Pair(arr[i],i));   // first 3 values of array and their index store one by one.
        }
        res[0] = pq.peek().val;
        for(int i=k;i<n;i++){
            while(pq.size()>0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            res[i-k+1] = pq.peek().val;
        }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();



    }
}
