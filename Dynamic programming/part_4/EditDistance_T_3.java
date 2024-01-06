public class EditDistance_T_3 {
    public static int editDistance(String str1,String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        //initialize
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    dp[i][j] = j;
                }
                if(j==0){
                    dp[i][j] = i;
                }
            }
        }
        // bottom up filling
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1) == str2.charAt(i-1)){  // same
                    dp[i][j] = dp[i-1][j-1];

                }
                else{  //diff
                    int add = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];
                    dp[i][j] = Math.min(add, Math.min(replace,delete)) + 1;
                }
            }

        }
        return dp[n][m];
        
    }
    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";  // ans = 5
        System.out.println(editDistance(str1, str2));

    }
}
