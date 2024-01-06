public class CatalanNum_T_4 {
    public static int catalanTeb(int n){
        int dp[] = new int[n+1];
        // iniitialize
        dp[0] = 1;
        dp[1]= 1;
         // fill dp bottom up
         for(int i=2;i<=n;i++){  // ci find
            for(int j=0;j<i;j++){   // i-1 time loop
                dp[i]+= dp[j] * dp[i-j-1];  // for i=2 dp[2]+= dp[0]*dp[2-1]

            }
         }
         return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(catalanTeb(n));

    }
}
