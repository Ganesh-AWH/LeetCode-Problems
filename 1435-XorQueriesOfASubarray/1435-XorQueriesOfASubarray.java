// Last updated: 9/14/2025, 9:10:23 AM
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        //optimal solution
        int []prefixXor = new int[arr.length+1];
        prefixXor[0] = 0;
        int []res = new int[queries.length];
        int xr = 0;
        for(int i=1;i<=arr.length;i++){
            xr ^= arr[i-1];
            prefixXor[i] = xr;
        }
        int x = 0;
        System.out.println(Arrays.toString(prefixXor));
        for(int []query:queries){
            res[x++] = prefixXor[query[0]] ^ prefixXor[query[1]+1];
        }
        return res;
    }
}