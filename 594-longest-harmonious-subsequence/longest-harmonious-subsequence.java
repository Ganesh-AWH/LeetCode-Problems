class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int length = 0;
        while(j<nums.length){
            int diff = nums[j] - nums[i];
            if(diff == 1){
                length = Integer.max(length,j-i+1);
                j++;
            }else if(diff == 0){
                j++;
            }else{
                i++;
            }
        } 
        return  length;
    }
}