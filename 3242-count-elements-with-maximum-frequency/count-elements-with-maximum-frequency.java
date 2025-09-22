class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i:nums){
            map.put(i, map.getOrDefault(i, 0)+1);
            max = Integer.max(max, map.get(i));
        }
        int count = 0;
        for(int i:nums){
            if(map.get(i) == max){
                count++;
            }
        }
        return count;
    }
}