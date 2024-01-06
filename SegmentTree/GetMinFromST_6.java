public class GetMinFromST_6 {
    
    static int tree[];
    public static void init(int n){
        tree = new int[n*4];

    }
    public static void buildST(int i,int arr[],int si,int sj){
        // si= start
        // sj = end
        if(si==sj){   // leaf node
            tree[i] = arr[si];
            return;
        }
        int mid = (si+sj)/2;
        buildST(2*i+1, arr, si, mid);
         buildST(2*i+2, arr, mid+1, sj);
        tree[i] = Math.min(tree[2*i+1], tree[2*i+2]);
        return;
    }
    public static int getMinUtil(int i,int si,int sj,int qi,int qj){
        // case 1 (no overlap)
        if(qi>sj || qj<si){
            return Integer.MAX_VALUE;
        }
        //case 2 (complete overlap)
        else if(si>=qi && sj<=qj){
            return tree[i];
        }
        // case 3 (partially overlap)
        else{
            int mid = (si+sj)/2;
            int left = getMinUtil(2*i+1, si, mid, qi, qj);
            int right = getMinUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.min(left, right);
        }
    }
    public static int getMin(int arr[],int qi,int qj){
        int n = arr.length;
        //calling helperfunction
        return getMinUtil(0,0,n-1,qi,qj);
    }
    // update
    public static void update(int arr[],int idx,int newVal){
        int n = arr.length;
        arr[idx] = newVal;
        
        updateUtil(0,0, n-1, idx, newVal);
        
    }
    public static void updateUtil(int i,int si,int sj,int idx,int newVal){
        // out of range idx
        if(idx>sj || idx<si){
            return;
        }
        if(si==sj){
            tree[i] = newVal;   // at leaf node  no need compairision
        }
        if(si!=sj){
            tree[i] = Math.min(tree[i],newVal);
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, newVal);  // left
            updateUtil(2*i+2, mid+1, sj, idx, newVal);   // right

        }

    }
    public static void main(String[] args) {
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;
        init(n);
        buildST(0, arr, 0, n-1);
        System.out.println(getMin(arr, 2, 5));  // -1  
        update(arr, 2, 20);
        System.out.println(getMin(arr, 2, 5));  // 1

        
    }
}


