// Last updated: 9/14/2025, 9:10:54 AM
class Solution {
    public int[] replaceElements(int[] arr) {
        int rmax = -1;
        for(int i=arr.length-1;i>=0;i--){
            int temp = arr[i];
            arr[i] = rmax;
            rmax = Integer.max(rmax,temp);
        }
        return arr;
    }
}