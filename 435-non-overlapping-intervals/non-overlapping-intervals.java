class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[1] - b[1]);

        int end = Integer.MIN_VALUE;
        int count = 0;

        for(int []interval:intervals){
            //count the not overlap intervals 
            if(end<=interval[0]){
                count++;
                end = interval[1];
            }
        }

        return intervals.length - count;
    }
}