import java.util.*;
public class TrajonAP_3 {

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
        //graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        
        // vertex 1        
        graph[1].add(new Edge(1,0));       
        graph[1].add(new Edge(1,2));       
            
        
        // vertex 2
        
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        
        
        // vertex 3
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        //graph[3].add(new Edge(3,5));

        //graph[4].add(new Edge(4,5));        
        graph[4].add(new Edge(4,3)); 

       // graph[5].add(new Edge(5,3));        
       // graph[5].add(new Edge(5,4));        
    }
    public static void dfs(ArrayList<Edge> graph[],boolean[] vis,int dt[],int low[],int time,int curr,int par,boolean[] ap){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        // call neighbors
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);  //src ---- dest
            // 3 major steps
            //step 1
            if(e.dest==par){  // curr--> neighber == parent
                continue;
            }
            // step 2
            else if(!vis[e.dest]){
                dfs(graph,vis,dt,low,time,e.dest,curr,ap);

                low[curr] = Math.min(low[curr],low[e.dest]);  // update value of current after backtracking
                // 2 major condition of AP
                if(par!=-1 && dt[curr]<=low[e.dest]){
                    //System.out.println("AP: "+curr);
                    ap[curr] = true;                    
                }
                children++;
            }
            // step 3
            else{  // already neighbor visited case
                low[curr] = Math.min(low[curr],dt[e.dest]);
            }
        }
        if(par==-1 && children>1){
            //System.out.println("AP: "+curr);
            ap[curr] = true;
        }

    }
    public static void trajonAP(ArrayList<Edge> graph[],int v){
        boolean vis[] = new boolean[v];
        int dt[] = new int[v];
        int low[] = new int[v];
        boolean ap[] = new boolean[v];  // to store ans of ap
        int time = 0;
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(graph,vis,dt,low,time,i,-1,ap);
            }
        }
        for(int i=0;i<ap.length;i++){
            if(ap[i]){

                System.out.println("AP: "+i);
            }
            
        }
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        trajonAP(graph, v);
        
    }
}


