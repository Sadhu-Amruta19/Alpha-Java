import java.util.*;
public class LongestIncreasingSequence_2 {
    public static int lcs(int arr1[],int arr2[]){
        int n = arr1.length;
        int m = arr2.length;

        int dp[][] = new int[n+1][m+1];
        // initialize
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr1[i-1]== arr2[i-1]){  // both same

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
    public static int lis(int arr1[]){
        int n = arr1.length;

        HashSet<Integer> set = new HashSet<>();  // from original array store unique values
        for(int i=0;i<n;i++){
            set.add(arr1[i]);  // add all element from array to set..
        }
        int arr2[] = new int[set.size()];
        // from sets store all value in array2
        int i=0;
        for(int num : set){ // in  num all value store
            arr2[i] = num;    // and from num all value goes in arr2.
            i++; 
        }
        Arrays.sort(arr2);

        // perform lcs on arr1 and arr2
        return lcs(arr1,arr2);

        

    }
    public static void main(String[] args) {
        int arr[] = {50,3,10,7,40,80};
        System.out.println(lis(arr));
    }
   
}
