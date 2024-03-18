class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //solving using prefix sum approach
        int total = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int x = sum - goal;
            if(map.containsKey(x)){
                total += map.get(x);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return total;
    }
}