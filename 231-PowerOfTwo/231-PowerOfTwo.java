// Last updated: 9/14/2025, 9:15:21 AM
class Solution {
    public boolean isPowerOfTwo(int n) {
        //optimal solution
        return n>0 && (n & n-1) == 0;
    }
}