public class HeapSort {
    public static void heapify(int arr[],int i,int size){
        // i is root.
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;
        if(left<size && arr[left]>arr[maxIdx]){
            maxIdx = left;
        }
        if(right<size && arr[right]>arr[maxIdx]){
            maxIdx = right;
        }
        if(maxIdx!=i){
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapify(arr, maxIdx, size);
        }


    }
    public static void heapSort(int arr[]){
        //step 1  // make max heap sort

        int n = arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }

        // step 2  // again make max heap  by removing last element because that is max.
        // System.out.println(arr[0]); 
        // put larget at end
        for(int i=n-1;i>0;i--){
            //swap large to first

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // System.out.println(arr[0]);
            heapify(arr,0,i); // size change with i value. root = 0 mate j heapify call karie chhe.
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,1,2,6,8,8,10};
        heapSort(arr);
        for(int i=0;i<arr.length;i++){

            System.out.print(arr[i]+" ");
        }
    }
}
