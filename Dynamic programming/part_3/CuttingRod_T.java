public class CuttingRod_T{
    // length--> wt
    // price --> value
    // totalLength --> capacity

    public static int rodCutting(int length[],int price[],int rodLength,int n){
        
        int dp[][] = new int[n+1][rodLength+1];

        // initialization
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<rodLength+1;j++){
                dp[0][j] = 0;
        }

        // filling array
        for(int i=1;i<n+1;i++){
            for(int j=1;j<rodLength+1;j++){
                //valid condition
                if(length[i-1]<=j){
                    // include  // exclude both
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);  // whatever included that remove from j

                }
                else{
                    // exclude
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }
        print(dp);
        return dp[n][rodLength];   
            
    }
    public static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int rodLength = 8;
        System.out.println(rodCutting(length, price, rodLength, price.length));
    }
}

