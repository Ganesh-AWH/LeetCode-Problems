// Last updated: 9/14/2025, 9:18:01 AM
class Solution {
    public int[][] merge(int[][] intervals) {
        //Optimal solution
        List<int []> ans = new ArrayList<>();
        if(intervals.length == 0 || intervals ==null){
            return ans.toArray(new int[0][]);
        }
        // Comparator<int []> com  = new Comparator<>(){
        //     public int compare(int []a,int []b){
        //             return a[0]>b[0]?1:-1;
        //     }
        // };

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        for(int i=0;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(ans.isEmpty() || start>ans.get(ans.size()-1)[1]){
                ans.add(new int[]{start,end});
            }else{
                end = Integer.max(end,ans.get(ans.size()-1)[1]);
                ans.get(ans.size()-1)[1] = end;
            }
        }
        return ans.toArray(new int[0][]);
    }
}