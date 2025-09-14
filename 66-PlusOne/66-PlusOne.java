// Last updated: 9/14/2025, 9:17:51 AM
class Solution {
    public int[] plusOne(int[] digits) {

        int len  = digits.length;
        for(int i=len-1;i>=0;i--){
            if(digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i]+=1;
                return digits;
            }
        }

        digits = new int[len+1];
        digits[0] = 1;
        return digits;
    }
}