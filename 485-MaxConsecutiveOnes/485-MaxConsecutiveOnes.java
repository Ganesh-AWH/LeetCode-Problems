// Last updated: 9/14/2025, 9:13:50 AM
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for(int i:nums){
            if(i==1){
                count++;
                maxCount = Integer.max(maxCount,count);
            }else{
                count = 0;
            }
        }
        return maxCount;
    }
}