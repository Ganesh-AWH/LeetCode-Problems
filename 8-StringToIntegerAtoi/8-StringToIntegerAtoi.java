// Last updated: 9/14/2025, 9:19:14 AM
class Solution {
    public int myAtoi(String s) {
        long ans = 0;
        int len = s.length();
        int i=0;
        for(;i<s.length();i++){
            if(s.charAt(i)!=' ') break;
        }
        int sign = i<len && s.charAt(i)=='-'?-1:1;
        if(i<len && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            i++;
        }
        for(;i<s.length();i++){
            int num = s.charAt(i) - '0';
            if(num>=0 && num<=9){
                ans = ans*10 + num;
            }else{
                break;
            }
            if (ans*sign >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (ans*sign <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        ans *= sign;
        return (int)ans;
    }
}