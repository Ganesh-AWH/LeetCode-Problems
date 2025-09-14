// Last updated: 9/14/2025, 9:19:15 AM
class Solution {
    //palindrome using recursion
    public boolean isPalindrome(int x) {
        int digits = (int)Math.log10(x) +1;
        if(x<0) return false;
        return helper(x,digits)==x;
    }
    private static int helper(int x,int digits){
        if(x%10 == x) return x;

        int rem = x%10;

        return (int)Math.pow(10,digits-1) * rem + helper(x/10,digits-1);
    }
}