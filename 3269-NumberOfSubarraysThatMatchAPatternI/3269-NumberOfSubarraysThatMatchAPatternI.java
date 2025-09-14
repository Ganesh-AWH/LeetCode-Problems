// Last updated: 9/14/2025, 9:07:45 AM
class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int count = 0;
        int n = nums.length;
        int m = pattern.length;
        for(int i=0;i<n-m;i++){
            boolean flag = true;
            for(int k=0;k<m;k++){
                if(pattern[k] == 1 && !(nums[i+k]<nums[i+k+1])){
                    flag = false;
                    break;
                }
                else if(pattern[k] == 0 && !(nums[i+k]==nums[i+k+1])){
                    flag = false;
                    break;
                }
                else if(pattern[k] == -1 && !(nums[i+k]>nums[i+k+1])){
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        
        return count;
    }
}