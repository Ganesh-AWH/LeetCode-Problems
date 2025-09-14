// Last updated: 9/14/2025, 9:16:00 AM
class Solution {
    public void rotate(int[] nums, int k) {
        int  len = nums.length;
        k = k % len;
        if(k == 0) return;
        k--;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k);
        reverse(nums, k+1, nums.length-1);
    }
    public static void reverse(int []arr, int start, int end){
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    public static void swap(int []arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}