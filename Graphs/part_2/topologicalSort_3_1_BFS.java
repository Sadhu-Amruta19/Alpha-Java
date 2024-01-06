package part_2;
import java.util.*;
public class topologicalSort_3_1_BFS {
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
      
        
        // vertex 1
        
        
        
        // vertex 2
        
        graph[2].add(new Edge(2,3));

        // vertex 3
        graph[3].add(new Edge(3,1));
      

        // vertex 4
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
       

    }
    public static void countIndeg(ArrayList<Edge> graph[],int indeg[]){
        // for loop for whole graph..
        for(int i=0;i<graph.length;i++){
            int vertex = i;
            for(int j=0;j<graph[vertex].size();j++){
                Edge e = graph[vertex].get(i);
                indeg[e.dest]++; // cause edge came from current to there neighbor.
            }
            
        }
    }
    public static void toposort(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        countIndeg(graph,indeg);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        // bfs
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr);

            // find neighbor of curr
            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;  // (indegree-1) from indegree  for curr's neighbor (this is kind of visited)
                if(indeg[e.dest]==0){
                    q.add(e.dest);
                }


            }
        }

    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        toposort(graph);
    }
    
}
