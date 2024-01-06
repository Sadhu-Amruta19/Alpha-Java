public class LongestCommonSeq_T_4 {
    public static int lcsTab(String str1,String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        // initialize
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;  // diagonal+1
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);  // max(up cell of curr idx,left cell of curr idx)
                }
            }
        }
        return dp[n][m];  // last row-col of dp array.

        
    }
    public static void main(String[] args) {
        String str1 = "pear";  // length = 5
        String str2 = "sea";   // length = 3
        System.out.println(lcsTab(str1, str2));
    }
}
