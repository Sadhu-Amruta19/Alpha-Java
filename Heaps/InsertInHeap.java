import java.util.*;
public class InsertInHeap {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            arr.add(data);
            int x = arr.size()-1;  // added last element
            int parent = (x-1)/2;  // parent of last element
            // fix heap
            while(arr.get(x)<arr.get(parent)){
                int temp = arr.get(x);
                arr.set(x,arr.get(parent));
                arr.set(parent,temp);

                x=parent;
                parent=(x-1)/2;

            }
            
        }
        public int peek(){
            return arr.get(0);
        }
        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;
            if(left<arr.size() && arr.get(minIdx)>arr.get(left)){  // check left child min
                minIdx=left;
            }
            if(right<arr.size() && arr.get(minIdx)>arr.get(right)){  // check right child min
                minIdx=right;
            }
            if(minIdx!=i){
                //swap
                int temp = arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);
                heapify(minIdx);
            }

        }
        public int remove(){
            int  data = arr.get(0);
            //step 1
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            //step 2
            arr.remove(arr.size()-1);

            //step 3
            heapify(0);
            return data;


        }
        public boolean isEmpty(){
             return arr.size()==0;
            //     return true;
            // }
            // return false;
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(10);
        while(!h.isEmpty()){

            System.out.println(h.peek());
            h.remove();
        }

        
    }
    
}
