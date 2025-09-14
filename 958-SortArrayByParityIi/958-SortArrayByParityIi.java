// Last updated: 9/14/2025, 9:11:46 AM
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int []ans = new int[nums.length];
        int evenIndex = 0;
        int oddIndex = 1;

        for(int i:nums){
            if(i%2==0){
                ans[evenIndex] = i;
                evenIndex+=2;
            }else{
                ans[oddIndex] = i;
                oddIndex+=2;
            }
        }

        return ans;
    }
}