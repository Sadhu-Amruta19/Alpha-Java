public class CreateSegmentTree_1 {
    static int tree[];
    public static void init(int n){
        tree = new int[4*n];
    }
    public static int buildST(int num[],int i,int st,int end){  //O(logn)
        // base case
        if(st==end){
            tree[i] = num[st];
            return num[st];
        }
        int mid = (st+end)/2;
        int left = buildST(num, 2*i+1, st, mid);  // left subtree
        int right = buildST(num, 2*i+2, mid+1, end);  // right subtree
        tree[i] = left+right;  // root node from here called to left child and right child
        return tree[i];


    }
    public static void main(String[] args) {
        int num[] = {1,2,3,4,5,6,7,8};
        int n = num.length;
        init(n);
        buildST(num, 0, 0, n-1);

        // print array of segment tree
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
    }
}
