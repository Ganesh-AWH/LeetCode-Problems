// Last updated: 9/14/2025, 9:15:32 AM
class Solution {
    public boolean containsDuplicate(int[] nums) {
        //using set add elements if duplicate found return
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){return true;}
            set.add(nums[i]);
        }
        return false;
    }
}