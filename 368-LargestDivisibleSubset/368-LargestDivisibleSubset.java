// Last updated: 9/14/2025, 9:14:27 AM
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 1 7 4 16 8
        //sort -> 1 4 7 8 16
        // 1 4 8 16 if 16 is divisble by 8 then it is divisible by 4 and 1

        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        // it is extension of longest increasing subsequence
        int []dp = new int[n];
        int []hash = new int[n];
        Arrays.fill(dp, 1);
        int maxIndex = 0;
        for(int index=0; index<n; index++){
            hash[index] = index;
            for(int prev=0; prev<index; prev++){
                if(nums[index] % nums[prev] == 0 && dp[prev]+1 > dp[index]){
                    dp[index] = dp[prev] + 1;
                    hash[index] = prev;
                }
            }
            if(dp[maxIndex] < dp[index]){
                maxIndex = index;
            }
        }

        ans.add(nums[maxIndex]);
        while(hash[maxIndex] != maxIndex){
            maxIndex = hash[maxIndex];
            ans.add(nums[maxIndex]);
        }
        Collections.reverse(ans);
        return ans;
    }
}