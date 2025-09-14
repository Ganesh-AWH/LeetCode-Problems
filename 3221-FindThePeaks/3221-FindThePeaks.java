// Last updated: 9/14/2025, 9:07:49 AM
class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList<>();
        if(mountain.length==2) return ans;
        for(int i=1;i<mountain.length-1;i++){
            if(mountain[i-1]< mountain[i] && mountain[i] > mountain[i+1]){
                ans.add(i);
            }
        }
        return ans;
    }
}