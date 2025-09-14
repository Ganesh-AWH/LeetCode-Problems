// Last updated: 9/14/2025, 9:17:46 AM
class Solution {
    public int mySqrt(int x) {
        //using binary search approach

        //method binary search on answers

        long s = 0;
        long e = x;
        int ans = 0;
        while(s<=e){
            long mid = s + (e - s)/2;
            if(mid*mid <= x){
                ans = (int) mid;
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return ans;
    }
}