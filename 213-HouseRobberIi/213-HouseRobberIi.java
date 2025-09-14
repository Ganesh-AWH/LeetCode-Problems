// Last updated: 9/14/2025, 9:15:36 AM
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length==1) return nums[0];
        int []rob1 = new int[n];
        int []robn = new int[n];
        for(int i=0;i<n;i++){
            if(i!=0){
                //if I rob nth house I should not rob the house 1
                robn[i] = nums[i];
            }
            if(i != n-1){
                //if I rob 1th house I should not rob the house n
                rob1[i] = nums[i];
            } 
        }

        return Integer.max(robber(rob1),robber(robn));
    }
    public int robber(int[] nums) {
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