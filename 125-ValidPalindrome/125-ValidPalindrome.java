// Last updated: 9/14/2025, 9:16:49 AM
class Solution {
    public boolean isPalindrome(String s) {
         char []str= new char[s.length()];
         int x=0;
         for(char c:s.toCharArray()){
                if(Character.isDigit(c) || Character.isAlphabetic(c)){
                    str[x++]=Character.toLowerCase(c);
                }
         }
         int mid=x/2;
         int i=0,j=x-1;
         while(i<mid){
             if(str[i]!=str[j]){
                 return false;
             }
             i++;
             j--;
         }
         return true;
    }
}