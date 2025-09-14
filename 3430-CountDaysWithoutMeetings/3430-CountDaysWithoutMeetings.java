// Last updated: 9/14/2025, 9:07:29 AM
class Solution {
    public int countDays(int days, int[][] meetings) {
        int [][]nonOverlap = merge(meetings);
        int workingDays = 0;
        for(int []meeting:nonOverlap){
            workingDays += meeting[1] - meeting[0] + 1;
        }

        return days - workingDays;
    }
    public int[][] merge(int[][] intervals) {
        //sort the array based on starting 
        List<int []> ans = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        if(intervals.length == 0 ){
            ans.toArray(new int[0][]);
        }
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            //the condition if for overlap
            if(end>=intervals[i][0]){
                end = Math.max(end,intervals[i][1]);
            }else{
                ans.add(new int[]{start,end});
                end = intervals[i][1];
                start = intervals[i][0];
            }
        }

        ans.add(new int[]{start,end});

        return ans.toArray(new int[0][]);
    }
}