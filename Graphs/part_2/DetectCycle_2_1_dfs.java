package part_2;
import java.util.*;
public class DetectCycle_2_1_dfs {
    static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            this.src = s;
            this.dest=d;
        }
        public static void createGraph(ArrayList<Edge> graph[]){
            for(int i=0;i<graph.length;i++){
                graph[i] = new ArrayList<>();
            }
            graph[0].add(new Edge(0, 1));
            graph[0].add(new Edge(0, 3));
            graph[0].add(new Edge(0, 2));
            graph[1].add(new Edge(1,0));
            graph[1].add(new Edge(1,2));
            graph[2].add(new Edge(2,0));
            graph[2].add(new Edge(2,1));
            graph[3].add(new Edge(3,0));
            graph[3].add(new Edge(3,4));
            graph[4].add(new Edge(4,3));
        }
        public static boolean detectcycle(ArrayList<Edge> graph[]){
            boolean vis[] = new boolean[graph.length];
            for(int i=0;i<graph.length;i++){  // imagine multiple graph.
                if(!vis[i]){
                    if(detectcycleutil(graph,vis,i,-1)){  // if any cycle exist in multiple graph
                        return true;

                    }
                }
            }
            return false;

        }
        public static boolean detectcycleutil(ArrayList<Edge> graph[],boolean vis[],int curr,int parent){
            vis[curr]=true;
            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                // case 1
                if(!vis[e.dest]){    // e.dest mean --> neighbor.
                    if(detectcycleutil(graph,vis,e.dest,curr)){
                        return true;
                    }
                }
                //case 3
                else if(vis[e.dest] && e.dest!=parent){
                    return true;
                }
                //case 2
                // do nothing
            }
            return false;
        }
        public static void main(String[] args) {
            int V = 5;
            ArrayList<Edge> graph[] = new ArrayList[V];
            createGraph(graph);
            System.out.println(detectcycle(graph));
        }

        

    }
}
