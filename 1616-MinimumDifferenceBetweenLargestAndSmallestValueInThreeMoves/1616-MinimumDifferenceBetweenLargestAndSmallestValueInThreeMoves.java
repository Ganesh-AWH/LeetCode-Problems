// Last updated: 9/14/2025, 9:09:54 AM
class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        // we change all the number to the smallest
        if(n <= 4) return 0;

        Arrays.sort(nums);
        // Removing the three largest elements.
        // Removing the two largest and one smallest elements.
        // Removing one largest and two smallest elements.
        // Removing the three smallest elements.
        int left = 0;
        int right = n-4;
        int minDiff = Integer.MAX_VALUE;
        while(left < 4){
            minDiff = Integer.min(minDiff, nums[right] - nums[left]);
            left++;
            right++;
        }

        return minDiff;
    }
}