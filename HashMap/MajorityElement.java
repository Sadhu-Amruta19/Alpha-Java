import java.util.*;
public class MajorityElement {
    public static void main(String[] args) {
        int nums[] = {1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            // if(map.containsKey(nums[i])){  // key already exist made to...
            //     map.put(nums[i],map.get(nums[i])+1);
            // }
            // else{
            //     map.put(nums[i],1); // first time
            // }
            //sortcut
            map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
        }
        //print key
        // Set<Integer> keySet = map.keySet();  // store all  key
        for(Integer key : map.keySet()){ //print all key if condition true.
            if(map.get(key)>nums.length/3){
                System.out.println(key);

            }
        }
    }
}
