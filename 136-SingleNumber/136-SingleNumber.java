// Last updated: 9/14/2025, 9:16:40 AM
class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int num:nums){
            result=result^num;
        }
        return result;
    }
}