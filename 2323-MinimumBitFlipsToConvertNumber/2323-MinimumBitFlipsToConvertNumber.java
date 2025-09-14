// Last updated: 9/14/2025, 9:08:30 AM
class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        int mask = 1;
        for(int i=0;i<32;i++){
            mask = 1<<i;
            if(((mask & start)!=0 && (mask & goal)==0) || ((mask & start) == 0 && (mask & goal)!=0)){
                count++;
            }
        }
        return count;
    }
}