package part_2;
import java.util.*;
public class BipartiteGraph_2_2 {

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

        // vertex 4
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
    }
    public static boolean isbipartite(ArrayList<Edge> graph[]){
        int color[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            color[i]=-1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){  
                q.add(i);
                color[i] = 0;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e = graph[curr].get(j);
                        if(e.dest == -1){  // case 1
                            int nextcolor = color[curr] == 0 ? 1:0;
                            color[e.dest] = nextcolor;
                            q.add(e.dest);
                        }
                        else if(color[e.dest] == color[curr]){  //case 2
                            return false;

                        }
                    }
                }
            }
            // case 2

        }
        return true;

    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isbipartite(graph));
    }
}
