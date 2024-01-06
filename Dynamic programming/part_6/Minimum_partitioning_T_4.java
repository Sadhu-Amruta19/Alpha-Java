public class Minimum_partitioning_T_4 {

    // 0/1 knapsack
    public static int minPartition(int nums[]){
        int n = nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i]; // sum of element of array  
            //System.out.println(sum);          
        }
        // capacity
        int W = sum/2;
        
        int dp[][] = new int[n+1][W+1];
        // initialization of 0 is 0 in java it is in built
        for(int i=1;i<n+1;i++){   // tracking array number
            for(int j=1;j<W+1;j++){  // checking with 0th index suitable any index or not
                if(nums[i-1]<=j){   // valid
                    dp[i][j] = Math.max(nums[i-1]+dp[i-1][j-nums[i-1]], dp[i-1][j]);   // max(include,exclude)
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }

        }
        int sum1 = dp[n][W];  // knapsack made for sum1
        int sum2 = sum-sum1;
        return Math.abs(sum1-sum2);
    }
    public static void main(String[] args) {
        int nums[] = {1,6,11,5};
        System.out.println(minPartition(nums));
    }
}
