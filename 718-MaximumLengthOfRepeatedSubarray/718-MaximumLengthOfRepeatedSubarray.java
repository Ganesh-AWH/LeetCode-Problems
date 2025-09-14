// Last updated: 9/14/2025, 9:12:50 AM
class Solution {
    //Greedy approach
    public int findLength(int[] nums1, int[] nums2) {
        int [][]dp = new int[nums1.length+1][nums2.length+1];
        int max = 0;
        for(int i=1;i<=nums1.length;i++){
            for(int j=1;j<=nums2.length;j++){
                if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
//This is like a longest common subsequence in (DAA)
//But with different rule
/*
Rule:
> If both row and column characters are different then put dp[i][j] = 0;
> If both row and column characters are same the dp[i][j] = dp[i-1][j-1]+1;
> also take the max variable while memoization. 
 */