// Last updated: 9/14/2025, 9:14:55 AM
class Solution {
    public int findDuplicate(int[] nums) {
        //Using Array List
        Set<Integer> list = new HashSet<>();

        for(int i:nums){
            if(!list.add(i)) return i;
        }
        return 0;
    }
}