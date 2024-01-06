import java.util.*;
public class ConnectingCitiesMinCost_5_2 {
    static class Edge implements Comparable<Edge>{
        int dest;
        int cost;
        public Edge(int d,int wt){
            this.dest=d;
            this.cost = wt;
        }
        @Override
        public int compareTo(Edge e2){
            return this.cost - e2.cost;
        }
    }
    public static int connectCitiesMinCost(int cities[][]){
        boolean vis[] = new boolean[cities.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0,0));
        int finalcost = 0;
        
        while(!pq.isEmpty()){
            Edge curr = pq.remove();
            
            
            // check curr visited or not
            if(!vis[curr.dest]){
                vis[curr.dest]=true;
                finalcost+=curr.cost;
                

                // find neighbors

                for(int i=0;i<cities[curr.dest].length;i++){
                 
                    if(cities[curr.dest][i]!=0){  // if it 0 than it is not neighbor of curr.
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
    
                }
            }
            
           
        }
        return finalcost;

    }
    public static void main(String[] args) {
        int cities[][] = {{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};
        int n = cities.length;
        System.out.println(connectCitiesMinCost(cities));
    }
}
