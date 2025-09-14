// Last updated: 9/14/2025, 9:10:26 AM
class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;

        for(int i:nums){
            int digitCount = (int)Math.floor(Math.log10(i)+1);
            if(digitCount%2 == 0) count++;
        }

        return count;
    }
}