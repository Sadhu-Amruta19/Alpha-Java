public class LongestCommonSeq_R_2 {
    public static int lcs(String str1,String str2,int n,int m){
        // base case
        if(n==0 || m==0){
            return 0;
        }
        // same case
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return lcs(str1, str2, n-1, m-1)+1;
        }
        else{  // different
            int ans1 = lcs(str1, str2, n-1, m);   // str1 gatadyu
            int ans2 = lcs(str1, str2, n, m-1);   // str2 gatadyu
            return Math.max(ans1, ans2);

        }
    }
    public static void main(String[] args) {
        String str1 = "abcde";  // length = 5
        String str2 = "ace";   // length = 3
        System.out.println(lcs(str1, str2, str1.length(), str2.length()));
    }
}
