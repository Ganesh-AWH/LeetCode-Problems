// Last updated: 9/14/2025, 9:19:24 AM
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //optimal solution using hash map
        Map<Character,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int length = 0;
        while(r<s.length()){
            char c = s.charAt(r);
            if(map.containsKey(c)){
                int index = map.get(c);
                if(index>=l && index<=r){
                    l = index+1;
                }
            }
            map.put(c,r);
            length = Integer.max(length,r-l+1);
            r++;
        }
        return length;
    }
}