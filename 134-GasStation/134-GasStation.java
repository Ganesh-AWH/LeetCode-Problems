// Last updated: 9/14/2025, 9:16:39 AM
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //optimal solution
        int n = gas.length;
        int start = 0;
        long sum = 0;
        long diff = 0;
        for(int i=0;i<n;i++){
            sum += (gas[i] - cost[i]);
            if(sum < 0){
                diff = sum + diff;
                sum = 0;
                start = i+1;
            }
        }
        if(sum + diff >=0){
            return start;
        }
        return -1;
    }
}