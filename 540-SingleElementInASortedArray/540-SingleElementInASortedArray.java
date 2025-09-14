// Last updated: 9/14/2025, 9:13:32 AM
class Solution {
    public int singleNonDuplicate(int[] nums) {
        //naive approach
        int xor = 0;
        for(int i: nums){
            xor= xor ^ i;
        }
        return xor;
    }
}