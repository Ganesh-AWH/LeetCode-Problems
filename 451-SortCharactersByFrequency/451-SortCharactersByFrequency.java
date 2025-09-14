// Last updated: 9/14/2025, 9:13:55 AM
class Solution {

    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        List<Character> characters = new ArrayList<>(map.keySet());
        Collections.sort(characters,(a,b) -> map.get(b) - map.get(a));
        StringBuilder ans = new StringBuilder();
        for(char c:characters){
            for(int i=0;i<map.get(c);i++){
                ans.append(c);
            }
        }  
        return ans.toString();
    }
}