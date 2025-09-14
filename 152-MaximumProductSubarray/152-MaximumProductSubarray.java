// Last updated: 9/14/2025, 9:16:18 AM
class Solution {
    public int maxProduct(int[] nums) {
        //optimal solution
        int maxProduct = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        for(int i=0;i<nums.length;i++){
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
            prefix *= nums[i];
            suffix *= nums[nums.length-1-i];
            maxProduct = Integer.max(maxProduct,Integer.max(prefix,suffix));
        }
        return maxProduct;
    }
}