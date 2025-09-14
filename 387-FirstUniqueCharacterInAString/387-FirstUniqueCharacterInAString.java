// Last updated: 9/14/2025, 9:14:23 AM
class Solution {
    public int firstUniqChar(String s) {
        //using collections HashMap
        Map<Character,Integer> map = new HashMap<>();

        char []arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            char c = arr[i];
            if(!map.containsKey(c)) map.put(c,1);
            else map.put(c,map.get(c)+1);
        }
        for(int i=0;i<arr.length;i++){
            char c = arr[i];
            if(map.get(c) == 1) return i;
        }
        return -1;
    }
}