public class Knapsack_01_3T {
    public static int knapsackTab(int val[],int wt[],int W,int n){
        // n= no.of items
        // W = capacity
        int dp[][] = new int[n+1][W+1];

        // initialize

        for(int i=0;i<n+1;i++){ // row
            dp[i][0] = 0;
        }
        for(int j=0;j<W+1;j++){ // row
            dp[0][j] = 0;
        }
        for(int i =1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v= val[i-1];
                int w = wt[i-1];
                if(w<=j){
                    // include
                    int include = v+dp[i-1][j-w];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                }
                else{
                    int exclude = dp[i-1][j];
                    dp[i][j] = exclude;

                }
            }
            
        }
        print(dp);
        return dp[n][W];

    }
    public static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        System.out.println(knapsackTab(val, wt, W, val.length));
    }
    
}
