// Last updated: 9/14/2025, 9:16:54 AM
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //tabulation - with space optimization
        int n = triangle.size();
        int []front = new int[n];
        //base case
        for(int j=0;j<n;j++){
            front[j] = triangle.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--){
            int []curr = new int[n];
            for(int j=i;j>=0;j--){
                int down = triangle.get(i).get(j) + front[j];
                int diagonal = triangle.get(i).get(j) + front[j+1];
                curr[j] = Integer.min(down,diagonal);
            }
            front = curr;
        }
        return front[0];
    }
}