// Last updated: 9/14/2025, 9:07:35 AM
class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int hrs:hours){
            int remainder = hrs % 24;
            
            int complement = (24 - remainder) % 24;
            
            if(map.containsKey(complement)){
                count += map.get(complement); 
            }
            map.put(remainder,map.getOrDefault(remainder,0)+1);
        }
        
        return count;
    }
}