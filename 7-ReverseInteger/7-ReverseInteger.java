// Last updated: 9/14/2025, 9:19:17 AM
class Solution {
    public int reverse(int x) {
        //first find the number is positive or not
        if(x>0){
            //positive
            long reverse = 0;
            while(x>0){
                reverse = reverse * 10 + x % 10;
                x/=10;
            }
            if(reverse > Integer.MAX_VALUE) return 0;
            return (int)reverse;
        }

        //negative
        else{
            x *= -1;
            long reverse = 0;
            while(x > 0){
                reverse = reverse * 10 + x % 10;
                x/=10;
            }
            reverse *= -1;
            if(reverse < Integer.MIN_VALUE) return 0;
            return (int)reverse;
        }
    }
}