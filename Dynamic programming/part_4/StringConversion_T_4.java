public class StringConversion_T_4 {
    public static int lcs(String str1,String str2,int n,int m) {
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)== str2.charAt(j-1)){  // both same

                    dp[i][j] = dp[i-1][j-1]+1; // diagonal +1

                }
                else{  // different
                    int ans1 = dp[i-1][j];  // up cell
                    int ans2 = dp[i][j-1];   // left cell
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];

        
    }
    public static int stringConversion(String str1,String str2){
        int n = str1.length();
        int m = str2.length();
        int LongestCS = lcs(str1,str2,n,m);
        // count of delete operation
        int delete = n-LongestCS;
        
        // count of insert
        int insert = m-LongestCS;
        int ans = delete+insert;
        
        return ans;
    }
    public static void main(String[] args) {
        String str1 = "pear";
        String str2 = "sea";  // ans = 3
        System.out.println(stringConversion(str1, str2));
    }
}
