// Last updated: 9/14/2025, 9:16:01 AM
class Solution {
    public int majorityElement(int[] nums) {
        int voter = -1;
        int count = 0;

        for(int i:nums){
            if(voter==i) count++;
            else if(count == 0){
                voter = i;
                count = 1;
            }
            else count--;
        }

        return voter;
    }
}