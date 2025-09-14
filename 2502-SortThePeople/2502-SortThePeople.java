// Last updated: 9/14/2025, 9:08:20 AM
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // approach - 2 using index
        int n = names.length;
        Integer []index = new Integer[n];
        for(int i=0; i<n; i++) index[i] = i;
        Arrays.sort(index, (a, b) -> heights[b] - heights[a]);

        String []ans = new String[n];

        for(int i=0; i<n; i++){
            ans[i] = names[index[i]];
        }

        return ans;

    }
}