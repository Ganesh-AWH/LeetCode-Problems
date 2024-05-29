class Solution {
    public int numSteps(String s) {
        int count = 0;
        int l = s.length()-1;
        int carry = 0;

        //Note: even number binary have last digit '0'
        //odd number binary binary have last digit '1'
        while(l>0){
            int digit = s.charAt(l) - '0';
            //even number with carry = 0, result even
            if(digit + carry == 0){
                //no carry
                carry = 0;
                count++;
            }
            //odd number with carry = 1, result even
            else if(digit + carry == 2){
                //carry will remain same 1
                carry = 1;
                count++;
            }
            //odd number with carry = 0 , result odd
            //even number with carry = 1, result odd
            else{
                carry = 1;
                //converting odd to even one step and removing the last 0 one step
                count+=2;
            }
            l--;
        }  
        if(carry == 1){
            count++;
        }   

        return count;
    }
}   