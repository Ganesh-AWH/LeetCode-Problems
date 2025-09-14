// Last updated: 9/14/2025, 9:09:11 AM
class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int []ans = new int[len*2];

        int i = 0;
        int j = len; 
        while(j<ans.length){
            ans[i] = nums[i];
            ans[j] = nums[i];

            i++;
            j++;
        }

        return ans;
    }
}