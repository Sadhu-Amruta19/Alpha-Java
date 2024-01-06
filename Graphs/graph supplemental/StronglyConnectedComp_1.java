import java.util.*;
public class StronglyConnectedComp_1 {
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
        
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        
        // vertex 1        
        graph[1].add(new Edge(1,0));       
            
        
        // vertex 2
        
        graph[2].add(new Edge(2,1));
        
        
        // vertex 3
        graph[3].add(new Edge(3,4));

        //graph[4].add(new Edge(4,4));

        
    }
    public static void toposort(boolean vis[],ArrayList<Edge> graph[],Stack<Integer> s,int curr){
        vis[curr] = true;
        //neighbors
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                toposort(vis, graph, s, e.dest);
            }
        }
        s.push(curr);
    }
    public static void dfs(ArrayList<Edge> graph[],boolean vis[],int curr){
        vis[curr] = true;
        System.out.print(curr+" ");
        //neighbors
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, vis, e.dest);
            }
        }

    }
    public static void kosaraju(ArrayList<Edge> graph[],int v){
        boolean vis[] = new boolean[v];
        Stack<Integer> s = new Stack<>();
        
        //step 1
        for(int i=0;i<v;i++){
            if(!vis[i]){
                toposort(vis,graph,s,i);
            }
        }

        // step 2
        ArrayList<Edge> transpose[] = new ArrayList[v];
        for(int i=0;i<graph.length;i++){
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }
        // neighbors
        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);   //e.src -> e.dest
                // transpose step
                transpose[e.dest].add(new Edge(e.dest, e.src));  // e.dest ni jagya e e.src..
            }
        }

        // step 3
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                System.out.print("scc -> ");
                dfs(transpose,vis,curr);
                System.out.println();
            }
        }


    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        kosaraju(graph, v);
        
    }
}
