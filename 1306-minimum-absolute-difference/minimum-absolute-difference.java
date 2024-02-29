class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            if(Math.abs(arr[i]-arr[i+1]) < min){
                min = Math.abs(arr[i] - arr[i+1]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<arr.length-1;i++){
            if(Math.abs(arr[i] - arr[i+1]) == min){
                ans.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }

        return ans;
    }
}