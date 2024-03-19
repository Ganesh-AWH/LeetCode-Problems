class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(x,y) -> {
            return x[1] - y[1];
        });
        int count = 0;
        int k = Integer.MIN_VALUE;
        for(int []interval:intervals){
            if(interval[0] >= k){
                count++;
                k = interval[1];
            }
        }
        return intervals.length - count;
    }
}