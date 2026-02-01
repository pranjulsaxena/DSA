public class max_product_array {
    public static int maxProduct(int[] nums) {
       int v1,v2,v3,maxProduct,minProduct,ans;
        ans = nums[0];
        minProduct=ans;
        maxProduct = minProduct;
        for(int i =1; i<nums.length;i++){
            v1=nums[i];
            v2=nums[i]*minProduct;
            v3=nums[i]*maxProduct;

            maxProduct=Math.max(v1,Math.max(v2,v3));
            minProduct = Math.min(v1,Math.min(v2,v3));
            ans = Math.max(ans,Math.max(minProduct,maxProduct));
        }       
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{1,-2,0,4,-6}));
    }
}