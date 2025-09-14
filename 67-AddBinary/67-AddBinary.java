// Last updated: 9/14/2025, 9:17:49 AM
class Solution {
    public String addBinary(String a, String b) {
        //string builder is class it used for consume  memory ans use it efficiently with various methods
        StringBuilder ans = new StringBuilder();

        int i=a.length()-1;
        int j=b.length()-1;

        //initialize carry as zero
        int carry = 0;
        while(i>=0 || j>=0){
            int sum = carry;
            if(i>=0) sum+= a.charAt(i) - '0';
            if(j>=0) sum+= b.charAt(j) - '0';

            ans.append(sum%2);
            carry = sum/2;
            
            i--;
            j--;
        }
        //if carry contains element the add it to the result
        if(carry!=0) ans.append(carry);
        
        //adding from last so reverse the sum
        return ans.reverse().toString();
    }
}