public class max_sum_subarray_one_deletion {
    public static int maximumSum(int[] arr) {
        int ans,nodelete,onedelete,v1,v2;
        ans = arr[0];
        nodelete = ans;
        onedelete = 0;
        for(int i =1; i<arr.length; i++){
            v1 = nodelete;
            if(i==1){
                onedelete = v1;
            }else{
                v2 = onedelete + arr[i];
                onedelete = Math.max(v1,v2);
            }
            nodelete = Math.max(nodelete+arr[i],arr[i]);
            ans = Math.max(ans,Math.max(onedelete,nodelete));
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{-2,1,3,4,-6,-7,9}));
    }
}