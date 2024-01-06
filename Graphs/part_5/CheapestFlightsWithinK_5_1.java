import java.util.*;
public class CheapestFlightsWithinK_5_1 {
    public static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int wt){
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[],int flights[][]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<flights.length;i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);

        }

    }
    public static class Info{
        int v;
        int cost;
        int stops;
        public Info(int v,int c,int k){
            this.v=v;
            this.cost=c;
            this.stops=k;

        }
    }
    public static int cheapestFlight(int n,int flights[][],int src,int dest,int k){
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, flights);
        int dist[] = new int [n];
        for(int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        //required one info class that store vertex,cost,stops.
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src,0,0));
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops>k){
                break;
            }
            // find neighbor
            for(int i=0;i<graph[curr.v].size();i++){
                Edge e = graph[curr.v].get(i);
                int u = e.src;   // no need in future
                int v= e.dest;
                int wt = e.wt;

                if((curr.cost+wt)<dist[v] && curr.stops<=k){   // update dist of curr.neighbor.vertex
                    dist[v] = curr.cost+wt;

                    q.add(new Info(v,dist[v],curr.stops+1));
                }
            }
        }
        if(dist[dest]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[dest];

    }
    public static void main(String[] args) {
        int flights[][] = {{0,1,100},{1,2,100},{0,2,500}};
        int n= flights.length;
        System.out.println(cheapestFlight(n,flights,0,2,1));
    }
}
