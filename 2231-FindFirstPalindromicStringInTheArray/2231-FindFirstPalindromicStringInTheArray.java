// Last updated: 9/14/2025, 9:08:40 AM
class Solution {
    public boolean checkPalindrome(String s){
        char []arr = s.toCharArray();
        int mid = s.length()/2;
        int i = 0;
        int j = s.length()-1;
        while(i < mid){
            if(arr[i] != arr[j] ){
                return false;
            }
            i++;
            j--;
        } 
        return true;
    } 
    public String firstPalindrome(String[] words) {
        for(String word:words){
            if(checkPalindrome(word)) return word;
        }
        return "";
    }
}