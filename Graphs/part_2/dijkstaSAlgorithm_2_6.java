package part_2;
import java.util.*;
public class dijkstaSAlgorithm_2_6 {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt=w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){

        
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        // vertex 0    
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        
        // vertex 1        
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));
        
        
        // vertex 2
        
        graph[2].add(new Edge(2,4,3));

        // vertex 3
        graph[3].add(new Edge(3,5,1));
      

        // vertex 4
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

        graph[5].add(new Edge(5,5,0));
       

    }
    static class Pair implements Comparable<Pair>{
        int N; // vertex
        int path; // distance
        Pair(int N,int path){
            this.N=N;
            this.path=path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;
        }

    }
    public static void dijikstra(ArrayList<Edge> graph[],int src){
        int dist[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));// first add src and initially path = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.N]){
                vis[curr.N] = true;
                // neighbor of current node
                for(int i=0;i<graph[curr.N].size();i++){
                    Edge e = graph[curr.N].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt = e.wt;
                    if(dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
                for(int i =0;i<dist.length;i++){
                    System.out.print(dist[i]+" ");
                }
                System.out.println();
            }


        }

        // print all source to vertices shortest path
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijikstra(graph,0);
    }
    
}
