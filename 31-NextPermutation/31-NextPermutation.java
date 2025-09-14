// Last updated: 9/14/2025, 9:18:37 AM
class Solution {
    public void nextPermutation(int[] nums) {
        int breakingPoint = -1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]) {
                breakingPoint = i;
                break;
            }
        }

        if(breakingPoint == -1){
            reverse(nums, 0, nums.length-1);
            return;
        }

        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] > nums[breakingPoint]){
                swap(nums, i, breakingPoint);
                break;
            }
        }

        reverse(nums, breakingPoint+1, nums.length-1);

    }
    public static void reverse(int []arr, int s, int e){
        while(s < e){
            swap(arr, s, e);
            s++;
            e--;
        }
    }
    public static void swap(int []arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
Algorithm steps
1. find the breaking point (a[i] < a[i+1])
2. If breaking point is not present just reverse the array
3. In the breaking point someone greater than 
4. Reverse remaining portion
 */