// Last updated: 9/14/2025, 9:16:19 AM
class Solution {
    public String reverseWords(String s) {
        
        //used to remove the leading and trailing zeros
        s.strip();

        String []words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        int len = words.length;
        for(int i=len-1; i>=0; i--){
            String word = words[i];
            if(!word.isEmpty()){
                sb.append(word);
                sb.append(" ");
            }
        }

        // sb.append(word[0]);
        return sb.toString().trim();
    }
}