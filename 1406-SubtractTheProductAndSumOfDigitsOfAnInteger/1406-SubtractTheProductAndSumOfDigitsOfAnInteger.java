// Last updated: 9/14/2025, 9:10:29 AM
class Solution {
    public int subtractProductAndSum(int n) {
        int p = POD(n);
        int s = SOD(n);
        return p - s;
    }
    private static int POD(int n){
        int res = 1;
        while(n>0){
            res *= n%10;
            n/=10;
        }
        return res;
    }
    private static int SOD(int n){
        int res = 0;
        while(n>0){
            res += n%10;
            n/=10;
        }
        return res;
    }
}