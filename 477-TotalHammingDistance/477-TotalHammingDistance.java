// Last updated: 9/14/2025, 9:13:52 AM
class Solution {
    public int totalHammingDistance(int[] nums) {
        //Optimal solution
        int distance = 0;
        int n = nums.length;
        for(int i=0;i<32;i++){
            int ones = 0;
            int zeros = 0;
            int bit = 1 << i;
            for(int j:nums){
                if((bit & j)!=0) ones++;
                else zeros++;
            }
            if(ones == n || zeros == n) continue;
            else{
                distance += (ones * zeros);
            }
        }
        return distance;
    }
}