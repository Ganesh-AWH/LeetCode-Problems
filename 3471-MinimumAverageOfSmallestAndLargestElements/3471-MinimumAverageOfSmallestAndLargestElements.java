// Last updated: 9/14/2025, 9:07:16 AM
class Solution {
    public double minimumAverage(int[] nums) {
        double ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        
        while(i < j){
            double avg = (nums[i] + nums[j])/ 2.0;
            ans = Double.min(ans, avg);
            i++;
            j--;
        }
        
        return ans;
    }
}