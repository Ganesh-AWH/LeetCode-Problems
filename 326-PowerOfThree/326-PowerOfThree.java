// Last updated: 9/14/2025, 9:14:43 AM
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==0){
            return false;
        }
        if(n==1){
            return true;
        }
        while(n%3==0){
            n/=3;
        }
        return n==1;
    }
}