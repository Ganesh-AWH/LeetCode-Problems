class Solution {
    public int minCost(int n, int[] cuts) {
        //recursive approach
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i: cuts) list.add(i);
        list.add(n);
        Collections.sort(list);
        
        int len = cuts.length;
        int [][]dp = new int[len+1][len+1];
        for(int []row: dp) Arrays.fill(row, -1);

        return recursion(1, list.size()-2, list, dp);
    }
    public int recursion(int i, int j, List<Integer> cuts, int [][]dp){
        //base case
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        // partition
        int mini = Integer.MAX_VALUE;
        for(int k=i; k<=j; k++){
            int cost = cuts.get(j+1) - cuts.get(i-1) + recursion(i, k-1, cuts, dp) +
            recursion(k+1, j, cuts, dp);
            mini = Integer.min(mini, cost); 
        }
        return dp[i][j] = mini;
    }
}