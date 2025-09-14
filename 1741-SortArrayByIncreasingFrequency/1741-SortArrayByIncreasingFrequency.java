// Last updated: 9/14/2025, 9:09:33 AM
class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (a, b) -> {
            if(map.get(a) == map.get(b)) return b-a;
            else{
                return map.get(a) - map.get(b);
            }
        });
        
        int []ans = new int[n];
        int x = 0;
        for(Integer i: keys){
            int len = map.get(i);
            for(int j=0; j<len; j++){
                ans[x++] = i;
            }
        }
        return ans;
    }
}