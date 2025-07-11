class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        //approach -1 using map
        Map<Integer, String> map = new HashMap<>();
        int n = heights.length;
        for(int i=0; i<n; i++){
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);

        //descending order
        String []ans = new String[n];
        int x = 0;
        for(int i=n-1; i>=0; i--){
            ans[x++] = map.get(heights[i]);
        }

        return ans;
    }
}