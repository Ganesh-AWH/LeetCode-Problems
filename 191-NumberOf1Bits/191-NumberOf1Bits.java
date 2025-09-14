// Last updated: 9/14/2025, 9:15:58 AM
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
                count+=n&1;
            n=n>>>1;
        }
        return count;
    }
}