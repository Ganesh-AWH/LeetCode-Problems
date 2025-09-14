// Last updated: 9/14/2025, 9:12:38 AM
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int []m = new int[cost.length+1];
        int len = m.length;
        for(int i=2;i<len;i++){
            int a = m[i-1] + cost[i-1];
            int b = m[i-2] + cost[i-2];
            m[i] = Math.min(a,b);    
        }
        return m[len-1];
    }
}
