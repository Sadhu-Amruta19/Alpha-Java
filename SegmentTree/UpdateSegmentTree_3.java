public class UpdateSegmentTree_3 {
    static int tree[];
    public static void init(int n){
        tree = new int[4*n];
    }
    public static int buildST(int num[],int i,int st,int end){
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
    // helper function
    public static void updateUtil(int i,int si,int sj,int idx,int diff){   // O(logn)
        if(idx<si || idx>sj){   // index out of si-sj range
            return;
        }
        tree[i]+=diff;   // update range of sum
        if(si!=sj){ // non-leaf
            int mid = (si+sj)/2;
            updateUtil(2*i+1,si,mid,idx,diff);  // left call
            updateUtil(2*i+2,mid+1,sj,idx,diff);  // right call


        }
        System.out.println(idx);

    }
    public static int getsumUtil(int i,int si,int sj,int qi,int qj){
        if(qj<=si || qi>=sj){   // case 1: Non overlapping
            return 0;
        }
        else if(si>=qi && sj<=qj){   // case 2: complete overlap
            return tree[i];
            
        }
        else{              // case 3: partial overlap
            if(si!=sj){
                int mid = (si+sj)/2;
                int left = getsumUtil(2*i+1, si, mid, qi, qj);
                int right = getsumUtil(2*i+2, mid+1, sj, qi, qj);
                
                return left+right;
            }
            else{
                System.out.println(tree[i]);
                return tree[i];
                
            }

        }

    }
    public static int getSum(int num[],int qi,int qj){
        int n = num.length;
        return getsumUtil(0, 0, n-1, qi, qj);
        
    }
    
    public static void update(int num[],int idx,int newValue){
        int diff = newValue - num[idx];
        num[idx] = newValue;
        updateUtil(0,0,num.length-1,idx,diff);  // update segmentTree
    }
    public static void main(String[] args) {
        int num[] = {1,2,3,4,5,6,7,8};
        int n = num.length;
        init(n);
        buildST(num, 0, 0, n-1);
        System.out.println(getSum(num, 2, 5));
        update(num, 2, 2);
        System.out.println(getSum(num, 2, 5));

        
    }
}
