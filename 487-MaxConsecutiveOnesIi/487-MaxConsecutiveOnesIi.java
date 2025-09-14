// Last updated: 9/14/2025, 9:13:49 AM
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        //sliding window approach
        int max = 0;
        int i = 0;
        int zeros = 0;
        int j = 0;
        while(j<nums.length){
            if(nums[j]==0) zeros++;

            while(zeros == 2){
                if(nums[i] == 0){
                    zeros--;
                }
                i++;
            }
            max = Integer.max(max,j-i+1);
            j++;
        }

        return max;

    }
}