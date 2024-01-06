public class GetMaxFromST_4 {
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
    public static void main(String[] args) {
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;
        init(n);
        System.out.println(buildST(0, arr, 0, n-1));
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
    }
}
