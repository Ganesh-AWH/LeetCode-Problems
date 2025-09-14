// Last updated: 9/14/2025, 9:18:12 AM
class Solution {
    public double myPow(double x, int n) {
        long nn = n;
        if(n<0){
            nn = -1 * nn;
        }

        double ans =  helper(x,nn);
        if(n<0){
            ans = 1.0 / ans;
        }
        return ans;
    }
    private static double helper(double x,long n){
        if(n==0) return 1.0;
        double ans = 0;
        if(n%2 == 0){
            ans = helper(x,n/2);
            ans = ans * ans;
        }else{
            ans = x;
            ans = ans * helper(x,n-1);
        }
        return ans;
    }
}
//Time complexity 0(log n)