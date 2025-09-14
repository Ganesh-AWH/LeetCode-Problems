// Last updated: 9/14/2025, 9:12:39 AM
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
           for(char c : letters){
               if(c > target){
                   return c;
               }
           }
           return letters[0];
    }
}