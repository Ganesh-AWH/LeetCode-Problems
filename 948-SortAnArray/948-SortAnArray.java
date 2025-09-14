// Last updated: 9/14/2025, 9:11:47 AM
class Solution {
    public int[] sortArray(int[] nums) {
        //merge sorting
        divide(nums, 0, nums.length-1);
        return nums;
    }
    public static void divide(int []arr, int low, int high){
        if(low >= high) return;

        int mid = (high - low)/2 + low;

        divide(arr, low, mid);
        divide(arr, mid+1, high);

        merge(arr, low, mid, high);
    }
    public static void merge(int []arr, int low, int mid, int high){
        int left = low;
        int right = mid+1;
        int len = (mid-low+1) + (high-mid);
        int []temp = new int[len];
        int x = 0;
        while(left<=mid && right<=high){
            if(arr[left] <= arr[right]){
                temp[x++] = arr[left++];
            }else{
                temp[x++] = arr[right++];
            }
        }

        while(left<=mid){
            temp[x++] = arr[left++];
        }

        while(right<=high){
            temp[x++] = arr[right++];
        }

        for(int i=low; i<=high; i++){
            arr[i] = temp[i-low];
        }
    }
}