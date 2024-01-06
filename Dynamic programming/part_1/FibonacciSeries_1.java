public class FibonacciSeries_1 {
    public static int fibonacci(int n,int dp[]){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n] = fibonacci(n-1,dp)+fibonacci(n-2,dp);
        return dp[n];


    }
    public static void main(String[] args) {
        int n = 6;
        int dp[] = new int[n+1]; // initially all 0
        for(int i=0;i<n;i++){
            System.out.print(fibonacci(i,dp)+" ");      

        }

    }
}
