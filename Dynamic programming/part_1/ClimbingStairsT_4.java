import java.util.Arrays;
public class ClimbingStairsT_4 {


    // tebulation
    public static int ways(int n){
        int dp[] = new int[n+1];
        
        dp[0] = 1;  // one way to stand on 0
        
        for(int i=1;i<=n;i++){
            
            if(i==1){      // for nagative value
                dp[i] = dp[i-1];
            }
            else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
        

    }
    public static void main(String[] args) {
        int n=5;
        
        System.out.println(ways(n));
        
    }
}


