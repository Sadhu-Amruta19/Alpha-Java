public class Knapsack_01_2M {
    public static int knapsack(int val[],int wt[],int W,int i,int dp[][]){
        // base case
        if(i==0 || W==0){
            return 0;
        }
        if(dp[i][W]!=-1){
            return dp[i][W];

        }
        if(wt[i-1]<=W){  // valid condition
            // include
            int ans1 = val[i-1]+knapsack(val, wt, W-wt[i-1], i-1,dp);

            // exclude
            int ans2 = knapsack(val, wt, W, i-1,dp);
            dp[i][W] = Math.max(ans1, ans2);
            return dp[i][W];
            

        }
        else{  // exclude  wt>W
            dp[i][W] =  knapsack(val, wt, W, i-1,dp);
            return dp[i][W];
        }
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        int dp[][] = new int[val.length+1][W+1];
        for(int i=0;i<dp.length;i++){    // row
            for(int j=0;j<dp[0].length;j++){   // column
                dp[i][j] = -1;
            }
        }
        System.out.println("max profit: "+knapsack(val,wt,W,val.length,dp));
    }
}
