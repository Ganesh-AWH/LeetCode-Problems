class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char []arr = s.toCharArray();
        for(char c: arr){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        List<Character> characters = new ArrayList<>(map.keySet());
        Collections.sort(characters, (a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for(char c: characters){
            for(int i=0; i<map.get(c); i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}