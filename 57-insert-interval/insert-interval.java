class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int [][]ans = new int[intervals.length+1][2];
        int x = 0;
        for(int []interval:intervals){
            ans[x++] = interval;
        }
        ans[x++] = newInterval;
        return mergeOverlap(ans); 
    }
    public int[][] mergeOverlap(int [][]intervals){
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        List<int []> ans = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int []interval:intervals){
            //overlap
            if(end>=interval[0]){
                end = Integer.max(end,interval[1]);
            }else{
                ans.add(new int[]{start,end});
                end = interval[1];
                start = interval[0];
            }
        }

        ans.add(new int[]{start,end});

        return ans.toArray(new int[0][]);
    }
}