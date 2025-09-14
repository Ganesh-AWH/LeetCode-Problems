// Last updated: 9/14/2025, 9:07:37 AM
class Solution {
    public boolean isValid(String word) {
        int len  = word.length();
        if(len < 3) return false;
        int vowel = 0;
        int consonent = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        for(int i=0;i<len;i++){
            char c = word.charAt(i);
            //if it is character 
            if(Character.isLetter(c)){
                if(vowels.contains(c)) vowel++;
                else{
                    consonent++;
                }
            }else if(!Character.isDigit(c)) return false;
        }

        return vowel >= 1 && consonent >= 1;
    }
}