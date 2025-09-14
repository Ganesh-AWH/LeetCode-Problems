// Last updated: 9/14/2025, 9:13:11 AM
class Solution {
    public boolean judgeSquareSum(int c) {
        int s = 0;
        int e = (int)Math.sqrt(c);

        while(s<=e){
            long sq = (long)(Math.pow(e,2) + Math.pow(s,2));
            if(sq ==  c){
                return true;
            }
            else if(sq > c){
                e--;
            }else{
                s++;
            }
        }
        return false;
    }
}