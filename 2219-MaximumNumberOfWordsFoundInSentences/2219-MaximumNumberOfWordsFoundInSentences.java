// Last updated: 9/14/2025, 9:08:42 AM
class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = Integer.MIN_VALUE;
        for(String s:sentences){
            int len = s.split(" ").length;
            max = Integer.max(max,len);
        }
        return max;
    }
}