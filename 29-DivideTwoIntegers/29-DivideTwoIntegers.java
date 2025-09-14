// Last updated: 9/14/2025, 9:18:38 AM
class Solution {
    public int divide(int dividend, int divisor) {
        if(Integer.MIN_VALUE == dividend && divisor == -1){
            return Integer.MAX_VALUE;
        }
        boolean flag = true;
        if(dividend>0 == divisor >0){
            flag = false;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int ans = 0;
        while(dividend - divisor >= 0){
            int temp = divisor;

            int count = 1;
            while(dividend - (temp << 1) >= 0){
                temp = temp<< 1;
                count <<= 1;
            }
            dividend -= temp;
            ans += count; 
        }
        if(flag){
           ans *= -1; 
        }
        return ans;
    }
}