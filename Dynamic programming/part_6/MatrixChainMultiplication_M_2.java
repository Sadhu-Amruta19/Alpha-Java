import java.util.Arrays;

public class MatrixChainMultiplication_M_2 {
    public static int mcmMem(int arr[],int i,int j,int dp[][]){
        int k;
        
        // base case
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int ans = Integer.MAX_VALUE;
        for(k=i;k<=j-1;k++){
            int cost1 = mcmMem(arr, i, k,dp);   // before cut part  arr[i-1]*arr[k]
            int cost2 = mcmMem(arr, k+1, j,dp);  // after cut part   arr[k]*arr[j]
            int cost3 = arr[i-1]*arr[k]*arr[j];   // cost of cost1 and cost 2
            int finalcost = cost1+cost2+cost3;
            ans = Math.min(ans, finalcost);
            dp[i][j] = ans;
        }
        print(dp);
        return dp[i][j];
    }
    public static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        int n = arr.length;
        int dp[][] = new int[n][n]; 
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);   // row wise filling
        }
        System.out.println(mcmMem(arr, 1, n-1, dp));
    }
}
