// Last updated: 9/14/2025, 9:14:29 AM
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1){
            return true;
        }
        long start = 1L;
        long end = num;
        long mid = 0L;
        while(start <= end){
            mid = start + (end - start) /2;
            if(mid*mid == num){
                return true ;
            }else if(mid*mid > num){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return false;
    }
}