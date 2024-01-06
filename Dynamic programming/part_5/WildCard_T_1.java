public class WildCard_T_1 {
    public static boolean wildCard(String s,String p) {
        int n = s.length();
        int m = p.length();

        boolean dp[][]  = new boolean[n+1][m+1];

        // initialize
        // case 1:  s=" " p=" "
        dp[0][0] = true;

        // case 2:   p = " "
        for(int i=1;i<n+1;i++){
            dp[i][0] = false;
        }
        // case 3:  s=" "
        for(int j=1;j<m+1;j++){
            if(p.charAt(j-1) == '*'){

                dp[0][j] = dp[0][j-1];
            }
        }


        // bottom up
        
        for(int i =1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                // ith and jth same    // jth == ?
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                // jth palce == '*'
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }

            }
        }
        return dp[n][m];


        
    }
    public static void main(String[] args) {
        String s = "baaabab";
        String p = "*****ba*****ab";
        System.out.println(wildCard(s, p));
    }
}
