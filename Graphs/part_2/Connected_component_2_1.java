package part_2;
import java.util.*;

public class Connected_component_2_1 {
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
        // vertex 0
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        
        // vertex 1
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));
        
        
        // vertex 2
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        // vertex 3
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        // vertex 4
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }
    public static void bfs(ArrayList<Edge> graph[]){
        boolean visit[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
                bfsUtil(graph, visit);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge> graph[],boolean visited[]){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){  // current have false
                visited[curr]=true;
                System.out.print(curr+" ");
                // find neighbor
                for(int i=0;i<graph[curr].size();i++){
                    q.add(graph[curr].get(i).dest);
                }

            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[]){
        boolean visit[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            dfsUtil(graph, i, visit);
        }
    }
    public static void dfsUtil(ArrayList<Edge> graph[],int curr,boolean vis[]){
        System.out.print(curr+" ");
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph, e.dest, vis);
            }

        }
        
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dfs(graph);
        //bfs(graph);
       
    }
    
}
