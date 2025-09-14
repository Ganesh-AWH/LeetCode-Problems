// Last updated: 9/14/2025, 9:07:15 AM
class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for(int i:nums){
            int remainder = i % 3;
            if(remainder == 1 || remainder == 2) count += 1;
        }
        return count;
    }
}