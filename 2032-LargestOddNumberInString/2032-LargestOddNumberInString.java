// Last updated: 9/14/2025, 9:09:09 AM
class Solution {
    public String largestOddNumber(String num) {
        int len = num.length();
        for(int i=len-1; i>=0; i--){
            char c = num.charAt(i);
            int x = c-'0';
            if(x%2 !=0){
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}