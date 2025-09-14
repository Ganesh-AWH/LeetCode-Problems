// Last updated: 9/14/2025, 9:11:52 AM
class Solution {
    public int totalFruit(int[] fruits) {
        //summary: longest subarray atmost 2 diffrent elements
        //optimal approach using two pointers concept and hash map
        //fruits and its contiguous frequency
        HashMap<Integer,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxFruits = 0;
        while(r<fruits.length){
            int count = map.getOrDefault(fruits[r],0);
            map.put(fruits[r],count+1);
            while(map.size() > 2){
                int fruitsCount = map.get(fruits[l]);
                if(fruitsCount == 1){
                    map.remove(fruits[l]);
                }else{
                    map.put(fruits[l],fruitsCount - 1);
                }
                l++;
            }
            maxFruits = Integer.max(maxFruits,r-l+1);
            r++;
        }

        return maxFruits;
    }
}