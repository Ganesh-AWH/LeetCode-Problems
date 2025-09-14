// Last updated: 9/14/2025, 9:18:07 AM
class Solution {
    public int maxSubArray(int[] nums) {
        //Optimal solution (Kadane's algo)

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i:nums){
            sum+=i;
            maxSum = Integer.max(maxSum,sum);
            if(sum<0) sum = 0;
        }

        return maxSum;
    }
}