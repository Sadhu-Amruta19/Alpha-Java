import java.util.*;

public class Union_Intersaction {
    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        HashSet<Integer> set = new HashSet<>();
          // Union

          //add arr1 in to set.
          for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
            
          }
          //add arr2 in to set.
          for(int i=0;i<arr2.length;i++){
            
            set.add(arr2[i]);
          }

          System.out.println("Union "+set.size());
          System.out.println(set);

          //Intersection

          // clear set
          set.clear();

          // add arr1 in to set
          for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
          }
          int count = 0;
          for(int i=0;i<arr2.length;i++){

              if(set.contains(arr2[i])){
                count++;
                set.remove(arr2[i]);
              }
          }
          System.out.println("Intersection: "+count);
        
    }
}
