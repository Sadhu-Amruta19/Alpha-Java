import java.util.HashMap;

public class SubarrSumEqualK {
    public static void main(String[] args) {
        //int arr[]={10,2,-2,-20,10};
        int arr[]={1,2,3};
        int k=3;

        HashMap<Integer,Integer> map = new HashMap<>();

        int sum=0;
        int count=0;
        map.put(0,1);
        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            if(map.containsKey(sum-k)){   // sum-k is count if sum-k already exist than add that value in count.
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum, 0) + 1);  // in every case sum and count need to update.like (3,1)

        }
        System.out.println(count);
    }
}
