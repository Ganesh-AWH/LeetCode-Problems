class Solution {
    public boolean isIsomorphic(String s, String t) {
        //for the below code use pen and paper and solve this s="paper", t="titll"

        int len = Integer.min(s.length(), t.length());
        Map<Character, Character> map = new HashMap<>();

        for(int i=0; i<len; i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map.containsKey(c1)){
                if(map.get(c1) != c2) return false;
            }else if(map.containsValue(c2)){
                return false;
            }
            map.put(c1, c2);
        }

        return true;
    }
}