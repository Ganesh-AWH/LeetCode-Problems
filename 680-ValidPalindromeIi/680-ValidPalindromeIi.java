// Last updated: 9/14/2025, 9:12:56 AM
class Solution {
    static boolean checkPalindrome(char []arr,int i,int j){
           while(i<j){
               if(arr[i]!=arr[j]){
                   return false;
               }
               i++;
               j--;
           }
           return true;
    }
    public boolean validPalindrome(String s) {
        char str[]=s.toCharArray();
        int i=0,j=str.length-1,mid=str.length/2;
        while(i<mid){
            if(str[i]!=str[j]){
                 return (checkPalindrome(str,i,j-1) || checkPalindrome(str,i+1,j));   
            }
            i++;
            j--;
        }
        return true;
    }
}