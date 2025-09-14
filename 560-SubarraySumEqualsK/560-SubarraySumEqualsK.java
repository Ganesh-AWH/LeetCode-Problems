// Last updated: 9/14/2025, 9:13:21 AM
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map  = new HashMap<>();
        int count = 0;
        int sum = 0;
        // this is for first element is equal to k -> sum - k = 0
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int x = sum - k;
            if(map.containsKey(x)){
                count += map.get(x);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    //TC : O(N)
    //SC : O(N)
}