// Last updated: 9/15/2025, 8:36:58 PM
// This solution uses set
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<brokenLetters.length(); i++){
            char  c = brokenLetters.charAt(i);
            set.add(c);
        }

        int count = 0;
        String []words = text.split(" ");

        //it keep tracks of broken words
        for(String word: words){
            for(char c: word.toCharArray()){
                if(set.contains(c)){
                    count++;
                    break;
                }
            }
        }
        return words.length - count;
    }
}