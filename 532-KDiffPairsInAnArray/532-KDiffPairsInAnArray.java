// Last updated: 9/14/2025, 9:13:33 AM
class Solution {
    public int findPairs(int[] nums, int k) {
        //two pointers approach
        //first sort the array
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int j = 1;
        while(j<nums.length && i<nums.length){
            int diff = nums[j] - nums[i];
            if(i==j || diff < k) j++;
            else if(diff > k){
                i++;
            }else{
                i++;
                count++;
                //to remove duplicates
                while(i<nums.length && nums[i-1] == nums[i]) i++;
            }
        }

        return count;
    }
}