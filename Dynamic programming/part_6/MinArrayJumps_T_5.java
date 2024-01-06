public class MinArrayJumps_T_5 {
    public static int min_jumps(int jumps[]){
        int n = jumps.length;

        // create table
        int dp[] = new int[n];
        // initialize
        dp[n-1] = 0;

        // bottom up
        for(int i=n-2;i>=0;i--){
            int steps = jumps[i];
            int ans = Integer.MAX_VALUE;
            for(int j=i+1;j<=steps+i && j<n;j++){
                if(dp[j]!=-1){
                    ans = Math.min(ans,dp[j]+1);
                }
                
            }
            if(ans != Integer.MAX_VALUE){
                dp[i] = ans;
                
            }
        }
        print(dp);
        return dp[0];
    }
    public static void print(int dp[]) {
        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        
    }
    public static void main(String[] args) {
        int jumps[] = {2,3,1,1,4};
        System.out.println(min_jumps(jumps));

    }
    
}
