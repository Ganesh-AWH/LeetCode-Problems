// Last updated: 9/14/2025, 9:08:25 AM
class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character,Character> map = new HashMap<>();
        char alph = 'a';
        for(char c:key.toCharArray()){
            if(c!=' ' && (!map.containsKey(c))){
                map.put(c,alph);
                alph++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:message.toCharArray()){
            if(c!=' '){
                sb.append(map.get(c));
            }else{
                sb.append(" ");
            }
        }
        System.out.println(map);
        return sb.toString();
    }
}