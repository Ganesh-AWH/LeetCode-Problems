class Solution {
    public double myPow(double x, int n) {
        long nn = n;
        if(nn<0){
            nn = nn*-1;
        }
        double ans = helper(x, nn);
        if(n<0){
            ans = 1.0/ans;
        }
        return ans;
    }
    public static double helper(double x,long nn){
        if(nn==0){
            return 1.0;
        }

        double ans = 0;
        if(nn%2 == 0){
            ans = helper(x, nn/2);
            ans = ans*ans;
        }else{
            ans = x;
            ans = ans * helper(x, nn-1);
        }

        return ans;
    }
}