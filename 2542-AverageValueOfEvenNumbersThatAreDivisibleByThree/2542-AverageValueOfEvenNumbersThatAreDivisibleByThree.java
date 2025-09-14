// Last updated: 9/14/2025, 9:08:17 AM
class Solution {
    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for(int num:nums){
            if(num%2 == 0 && num%3==0){
                sum+=num;
                count++;
            }
        }
        return sum == 0 ? 0 : (int)sum/count;
    }
}