// Last updated: 9/14/2025, 9:14:56 AM
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while(j < nums.length){
            if(nums[j] != 0){
                nums[i++] = nums[j];
            }
            j++;
        }

        for(; i<nums.length; i++){
            nums[i] = 0;
        }
    }
}