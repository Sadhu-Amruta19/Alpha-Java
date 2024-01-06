public class LongestCommonSeq_M_3 {
    
    public static int lcs(String str1,String str2,int n,int m,int dp[][]){
        // base case
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m] !=-1){   // already have value of called n and m
            return dp[n][m];
        }      
        
        // same case
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return dp[n][m] = lcs(str1, str2, n-1, m-1,dp)+1;
            
        }
        else{  // different
            int ans1 = lcs(str1, str2, n-1, m,dp);   // str1 decreased
            int ans2 = lcs(str1, str2, n, m-1,dp);   // str2 decreased
            return dp[n][m] =  Math.max(ans1, ans2);
            
            
        }
          
        
    }
    public static void main(String[] args) {
        String str1 = "abcde";  // length = 5
        String str2 = "ace";
        // length = 3
        int n= str1.length();
        int m =  str2.length();     
        int dp[][] = new int[str1.length()+1][str2.length()+1];  // [n+1][m+1]
        
        //initialization
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][j] = -1;
            }
        }
        
        System.out.println(lcs(str1, str2, str1.length(), str2.length(),dp));
    }
}


