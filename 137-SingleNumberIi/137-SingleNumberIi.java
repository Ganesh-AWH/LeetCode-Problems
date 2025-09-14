// Last updated: 9/14/2025, 9:16:35 AM
class Solution {
    public int singleNumber(int[] nums) {
        //using bitwise operator
        //first write binary representation for all numbers in array
        //count how many bits are set on ith bit 
        //if it divides with 0 then that bit in ans is 0 or 1;
        int ans = 0;
        for(int i=0;i<32;i++){
            int mask = 1<<i;
            int bitCount = 0;
            for(int j=0;j<nums.length;j++){
                if((nums[j] & mask) != 0){
                    bitCount++;
                }
            }
            if(bitCount%3 != 0){
                ans = ans | mask;
            }
        }

        return ans;
    }
}