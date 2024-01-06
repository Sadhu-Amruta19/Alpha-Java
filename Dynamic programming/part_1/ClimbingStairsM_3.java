import java.util.Arrays;

public class ClimbingStairsM_3 {
    // memoization
    public static int ways(int n,int dp[]){
        if(n==0){
            return 1;  // one way
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = ways(n-1, dp)+ways(n-2, dp);
        return dp[n];

    }
    public static void main(String[] args) {
        int n=5;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(ways(n, dp));
        
    }
}
