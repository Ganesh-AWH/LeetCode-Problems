// Last updated: 9/14/2025, 9:07:44 AM
class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long ans = 0;

        Integer []diff = new Integer[nums.length];
        long sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            //find the difference (num ^ k) - num;
            diff[i] = (nums[i] ^ k) - nums[i];
        }

        //sort in descending order 
        Arrays.sort(diff,(a,b)->b-a);
        //choose pair wise element that should be in positive
        int positivePairs = 0;
        for(int i=0;i<diff.length-1;i+=2){
            // if(i+1 == diff.length) break;
            int pair = diff[i] + diff[i+1];
            if(pair > 0){
                sum += pair;
            }
        } 

        return sum;
    }
}