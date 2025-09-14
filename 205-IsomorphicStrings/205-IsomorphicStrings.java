// Last updated: 9/14/2025, 9:15:42 AM
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character,Character> map = new HashMap<>();
        int len  = Integer.min(s.length(),t.length());

        for(int i=0;i<len;i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map.containsKey(c1)){
                if(map.get(c1)!=c2) return false;
            }else if(map.containsValue(c2)) return false;
            map.put(c1,c2);
        }
        return true;
    }
}