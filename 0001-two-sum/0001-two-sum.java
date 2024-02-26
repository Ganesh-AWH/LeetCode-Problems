class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<len;i++){
            int x = target - nums[i];
            if(map.containsKey(x))
                return new int[]{i,map.get(x)};
            map.put(nums[i],i);
        }

        return new int[]{};
    }
}