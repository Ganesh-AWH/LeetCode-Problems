// Last updated: 9/14/2025, 9:07:42 AM
class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int []freq = new int[101];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        for(int i:freq){
            if(i>=3) return false;
        }
        return true;
    }
}