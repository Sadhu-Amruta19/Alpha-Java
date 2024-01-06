package part_2;
import java.util.*;
public class detectCycle_undirected_2_3 {
    static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
        
    }
    public static boolean iscycle(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(iscycleUtil(stack,vis,graph,i)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean iscycleUtil(boolean stack[],boolean vis[],ArrayList<Edge> graph[],int curr){
        vis[curr] = true;
        stack[curr]= true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){  // stack alread true..
                return true;
            }
            if(!vis[e.dest] && iscycleUtil(stack, vis, graph, e.dest)){  //neighbor not visited && cycle found by neighbor
                return true;
            }
        }
        stack[curr] = false;  // after perticular node make stack false.
        return false;

    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(iscycle(graph));
    }
}
