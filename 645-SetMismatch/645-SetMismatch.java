// Last updated: 9/14/2025, 9:13:08 AM
class Solution {
    public int[] findErrorNums(int[] nums) {
        //using xor operator
        int xor = 0;

        for(int i=0;i<nums.length;i++){
            xor ^= i+1;
            xor ^= nums[i];
        }

        //finding msb 
        int msb = 0;
        for(int i=31;i>=0;i--){
            if(((1<<i) & xor) != 0){
                msb = i;
                break;
            }
        }

        //segregation
        int ones = 0;
        int zeros = 0;
        for(int i=0;i<nums.length;i++){
            if(((1<<msb) & nums[i]) != 0) ones ^= nums[i];
            else zeros ^= nums[i];

            if(((1<<msb) & i+1) != 0) ones ^= i+1;
            else zeros ^= i+1;
        }
        //finding which one is missing and which is repeating
        for(int i:nums){
            if(ones == i) return new int[]{ones,zeros};
            else if(zeros == i) return new int[]{zeros,ones};
        }
        return new int[]{ones,zeros};
    }
}