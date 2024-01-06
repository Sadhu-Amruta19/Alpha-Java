import java.util.*;
public class krushkalAlgo_5_4 {
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int wt){
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }
    }
    public static void createGraph(ArrayList<Edge> edge){
        //edges
        edge.add(new Edge(0, 1,10));
        edge.add(new Edge(0, 2,15));
        edge.add(new Edge(0, 3,30));
        edge.add(new Edge(1, 3,40));
        edge.add(new Edge(2, 3,50));
   

    }
    static int n = 4; // vertexes
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for(int i=0;i<par.length;i++){
            par[i] = i;  // node itself parent initially
        }
    }
    public static int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x] = find(par[x]);  // store parent value in one call..
    }

    public static void union(int a,int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA]==rank[parB]){
            par[parB] = parA;
        }
        else if(rank[parA]<rank[parB]){
            par[parA] = parB;
        }
        else{
            par[parB] = parA;
        }
    }
    public static void krushkalMST(ArrayList<Edge> edge,int v){
        init();
        Collections.sort(edge);   // without implementation sorting not possible for class EDGE thats why override.
        int mstCount =0; // final answer
        int count =0; // counting of edges

        while(count<v-1){
            Edge e = edge.get(count);
            // src,dest,wt
            int parA = find(e.src); // a
            int parB = find(e.dest); // b

            if(parA != parB){
                union(parA,parB);
                mstCount+=e.wt;
                count++;
            }
        }
        System.out.println(mstCount);

    }
    public static void main(String[] args) {
        ArrayList<Edge> edge = new ArrayList<>();
        createGraph(edge);
        krushkalMST(edge, n);
        
    }
}
