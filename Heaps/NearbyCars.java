import java.util.*;
public class NearbyCars {
    static class Point implements Comparable<Point>{
        int x,y;
        int distance;
        int idx;
        Point(int x,int y, int distance,int idx){
            this.x=x;
            this.y=y;
            this.distance=distance;
            this.idx=idx;
        }
        @Override
        public int compareTo(Point p2){
            return this.distance - p2.distance;
        }
    }
    public static void main(String[] args) {
        int poits[][] = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int n = poits.length;
        for(int i=0;i<n;i++){  // adding all points in priorityQ
            int distance = poits[i][0]*poits[i][0]+poits[i][1]*poits[i][1];
            pq.add(new Point(poits[i][0],poits[i][1],distance,i)); // methood to add data in object.

        }
        //print newrest k cars:
        for(int i=0;i<k;i++){
            System.out.println("c"+pq.remove().idx);
        }
        
    }

    
    
}
