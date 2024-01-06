public class GetQueryMaxInST_5 {
    static int tree[];
    public static void init(int n){
        tree = new int[n*4];

    }
    public static int buildST(int i,int arr[],int si,int sj){
        // si= start
        // sj = end
        if(si==sj){   // leaf node
            tree[i] = arr[si];
            return arr[si];
        }
        int mid = (si+sj)/2;
        int left = buildST(2*i+1, arr, si, mid);
        int right = buildST(2*i+2, arr, mid+1, sj);
        tree[i] = Math.max(left, right);
        return Math.max(left, right);
    }
    public static int getMaxUtil(int i,int si,int sj,int qi,int qj){
        // case 1 (no overlap)
        if(qi>sj || qj<si){
            return Integer.MIN_VALUE;
        }
        //case 2 (complete overlap)
        else if(si>=qi && sj<=qj){
            return tree[i];
        }
        // case 3 (partially overlap)
        else{
            int mid = (si+sj)/2;
            int left = getMaxUtil(2*i+1, si, mid, qi, qj);
            int right = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(left, right);
        }
    }
    public static int getMax(int arr[],int qi,int qj){
        int n = arr.length;
        //calling helperfunction
        return getMaxUtil(0,0,n-1,qi,qj);
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
            tree[i] = Math.max(tree[i],newVal);
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
        System.out.println(getMax(arr, 1, 4));  // 17
        update(arr, 2, 20);
        System.out.println(getMax(arr, 1, 4));  //20

        
    }
}
