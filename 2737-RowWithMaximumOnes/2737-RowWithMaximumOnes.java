// Last updated: 9/14/2025, 9:08:06 AM
class Solution {
    private static int lengthArr(int []arr){
        int length = 0;
        for(int i:arr) length+=i;

        return length;
    }
    public int[] rowAndMaximumOnes(int[][] mat) {
        int []ans = new int[2];

        for(int i=0;i<mat.length;i++){
            int length = lengthArr(mat[i]);
            if(i==0){
                ans[0] = i;
                ans[1] = length;
            }
            else if(length>ans[1]){
                ans[0] = i;
                ans[1] = length;
            }
            else if(length == ans[1] && mat[i].length<mat[ans[0]].length){
                ans[0] = i;
                ans[1] = length;
            }
        }

        return ans;
    }
}