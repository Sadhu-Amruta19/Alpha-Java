public class Matrix_ChainMultiplication_R {
    public static int mcm(int arr[],int i,int j){
        int k;
        int ans = Integer.MAX_VALUE;
        
        // base case
        if(i==j){
            return 0;
        }
        for(k=i;k<=j-1;k++){
            int cost1 = mcm(arr, i, k);   // before cut part  arr[i-1]*arr[k]
            int cost2 = mcm(arr, k+1, j);  // after cut part   arr[k]*arr[j]
            int cost3 = arr[i-1]*arr[k]*arr[j];   // cost of cost1 and cost 2
            int finalcost = cost1+cost2+cost3;
            ans = Math.min(ans, finalcost);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        int n = arr.length;
        System.out.println(mcm(arr, 1, n-1));
    }
    
}
