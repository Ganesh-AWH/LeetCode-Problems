// Last updated: 9/14/2025, 9:12:32 AM
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        int count = 0;

        for(int i=0;i<arr.length;i++){
            maxElement = Integer.max(maxElement,arr[i]);

            if(i==maxElement) count++;
        }
        return count;
    }
}