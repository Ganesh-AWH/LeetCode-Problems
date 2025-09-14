// Last updated: 9/14/2025, 9:16:47 AM
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int max = 0;
        for(int i:set){
            //since we have to start from first
            if(!set.contains(i-1)){
                int x = i+1;
                while(set.contains(x)){
                    x++;
                }
                max = Integer.max(x-i,max);
            }
        }

        return max;
    }
}