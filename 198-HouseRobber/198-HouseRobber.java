// Last updated: 9/14/2025, 9:15:51 AM
class Solution {
    public int rob(int[] nums) {
        //Maximum Sum of Non-Adjacent Elements - Subsequences
        //Tabulation - with space optimization
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1;i<nums.length;i++){
            // int pick = nums[index] + dp[index-2];
            int pick = nums[i];
            if(i>1){
                pick += prev2;
            }
            int nonPick = 0 + prev;
            int curr = Integer.max(pick,nonPick);

            prev2 = prev;
            prev = curr;
        }
        return prev; 
    }
}