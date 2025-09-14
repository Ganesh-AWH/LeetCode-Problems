// Last updated: 9/14/2025, 9:09:03 AM
class Solution {
    //it is used for handling overflow of integer
    public static long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        //it can be solved using maths formula
        
        //first count the no of odd indices and even indices for the given number

        //to count odd 
        long odd = n/2;
        //to count even
        long even = (n/2 + n%2);

        return (int)(power(5,even) * power(4,odd)%MOD);
    }
    private static long power(long base,long n){
        if(n==0) return 1;

        long ans = 0;
        if(n%2==0){
            ans = power(base,n/2);
            ans = ans*ans;
            //handling over flow
            ans %= MOD;
        }else{
            ans = base;
            ans = ans * power(base,n-1);
            ans %= MOD;
        }
        return ans;
    }
}