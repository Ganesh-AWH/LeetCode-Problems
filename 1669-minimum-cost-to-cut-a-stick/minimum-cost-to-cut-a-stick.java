class Solution {
    public int minCost(int n, int[] cuts) {
        // tabulation approach
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i: cuts) list.add(i);
        list.add(n);
        Collections.sort(list);
        
        int len = cuts.length;
        int [][]dp = new int[len+2][len+2];

        int m = list.size();
        for(int i=m-2; i>=1; i--){
            for(int j=1; j<=m-2; j++){
                if(i > j) continue;
                int mini = Integer.MAX_VALUE;
                for(int k=i; k<=j; k++){
                    int cost = list.get(j+1) - list.get(i-1) + dp[i][k-1] + dp[k+1][j];
                    mini = Integer.min(mini, cost); 
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][m-2];
    }
}