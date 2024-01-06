public class MatricChainMultiplication_T {
    public static int mcmTab(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];

        // initialize
        for(int i=0;i<n;i++){
            
            dp[i][i] = 0;   // diagonal initialize
            
        }
        for(int len = 2;len<n;len++){   // small tolarge
            for(int i=1;i<=n-len;i++){  // // rows
                int j = i+len-1;  // col
                // memoization
                dp[i][j] = Integer.MAX_VALUE;   // i,j initialize infinity.
                for(int k=i;k<=j-1;k++){
                    int cost1 = dp[i][k];   // before cut part  arr[i-1]*arr[k]
                    int cost2 = dp[k+1][j];  // after cut part   arr[k]*arr[j]
                    int cost3 = arr[i-1]*arr[k]*arr[j];   // cost of cost1 and cost 2
                    int finalcost = cost1+cost2+cost3;
                    dp[i][j] = Math.min(dp[i][j], finalcost);
                }

            }

        }
        print(dp);
        return dp[1][n-1];  // 1st row and last column answer.
    }
    public static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                System.out.print(dp[i][j]+" ");

            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};  // n=5
        System.out.println(mcmTab(arr));
    }
    
}
