// Last updated: 9/14/2025, 9:10:34 AM
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //solving using prefix sum
        int oddCount = 0;
        int total = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] % 2 == 1) oddCount++;
            if(oddCount == k) total++;
            int req = oddCount - k;
            if(map.containsKey(req)){
                total += map.get(req);
            }
            map.put(oddCount,map.getOrDefault(oddCount,0)+1);
        }   
        return total;
    }
}