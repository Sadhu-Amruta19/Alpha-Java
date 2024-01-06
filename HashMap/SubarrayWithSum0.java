import java.util.*;
public class SubarrayWithSum0 {
    public static void main(String[] args) {
        int arr[] = {15,-2,2,-8,1,7,10};
        int sum=0;
        int len = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            if(map.containsKey(sum)){   // compair sum occured again or not.
                len = Math.max(len,j-map.get(sum));  // prev_length, current length.
            }
            else{
                map.put(sum,j); // everything is ok then add sum and index in hashmap.
            }
        }
        System.out.println("length of sub array with sum 0 is : "+len);

    }
    
}
