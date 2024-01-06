public class LongestCommonSubstr_T_1 {
    public static int commonLongestSubstr(String str1,String str2) {
        int n =  str1.length();
        int m = str2.length();
        int ans = 0;

        int dp[][] = new int[n+1][m+1];

        // initialize
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                
                
            }
        }
        // bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1) == str2.charAt(i-1)){
                    // same condition
                    dp[i][j] = dp[i-1][j-1] +1;   // diagonal+1
                    ans = Math.max(ans, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;   // substring broken start with again 0.
                }




            }
        }
        return ans;
        
    }
    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";   // ans = 2 "AB"
        System.out.println(commonLongestSubstr(str1, str2));
    }
}
