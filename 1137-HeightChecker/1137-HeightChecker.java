// Last updated: 9/14/2025, 9:11:08 AM
class Solution {
    public int heightChecker(int[] heights) {
        int []expected = heights.clone();
        Arrays.sort(expected);
        int count = 0;
        for(int i=0;i<heights.length;i++){
            if(heights[i] != expected[i]) count++;
        }
        return count;
    }
}