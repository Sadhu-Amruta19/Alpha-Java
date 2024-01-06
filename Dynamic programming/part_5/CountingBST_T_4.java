public class CountingBST_T_4 {
    public static int countBST(int n){
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] =1;

        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                // every i index store count of BST.
                int leftsubTree = dp[j];
                int rightsubTree = dp[i-j-1];
                dp[i]+=  leftsubTree*rightsubTree;
            }
        }
        return dp[n];

    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(countBST(n));
    }
}
