// Last updated: 9/14/2025, 9:09:51 AM
class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int totalCount = 0;
        for(Map.Entry<Integer,Integer> en:map.entrySet()){
            int num = en.getValue();
            totalCount += ((num)*(num-1))/2;
        }
        return totalCount;
    }
}