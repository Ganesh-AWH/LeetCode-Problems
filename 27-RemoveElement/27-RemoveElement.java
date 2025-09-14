// Last updated: 9/14/2025, 9:18:43 AM
class Solution {
    public int removeElement(int[] nums, int val) {
        // two pointers approach 
        //pointer1
        int  p1 = 0;
        //pointer2
        for(int p2=0;p2<nums.length;p2++){
            if(nums[p2]!=val){
                nums[p1] = nums[p2];
                p1++;
            }else{
                continue;
            }
        }
        return p1;
    }
}