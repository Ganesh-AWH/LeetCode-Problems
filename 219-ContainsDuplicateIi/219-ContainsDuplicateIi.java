// Last updated: 9/14/2025, 9:15:31 AM
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(Math.abs(map.get(nums[i])-i)<=k){
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }
}