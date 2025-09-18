class Solution {
    public int myAtoi(String s) {
        String numbers = s.trim();
        int len = numbers.length();
        if(len == 0) return 0;

        long ans = 0;
        int sign = numbers.charAt(0) == '-' ? -1: 1;
        int i=0;
        if(numbers.charAt(0) == '+' || numbers.charAt(0) == '-') i++;
        for(; i<len; i++){
            int digit = numbers.charAt(i) - '0';
            if(digit >= 0 && digit<=9){
                ans = ans*10 + digit;
            }else{
                break;
            }

            if(ans*sign >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }

            if(ans*sign <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        } 
        ans = ans*sign;
        return (int)ans;
    }
}