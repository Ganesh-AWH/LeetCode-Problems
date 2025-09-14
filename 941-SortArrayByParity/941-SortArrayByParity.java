// Last updated: 9/14/2025, 9:11:49 AM
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        //two pointer 
        int odd = nums.length-1;
        int even = 0;
        int i = 0;
        while(even < odd){
            if(nums[odd]%2==0 && nums[even]%2==1){
                swap(nums,odd,even);
                odd--;
                even++;
            }else if(nums[odd]%2==1) odd--;
            else even++;
        }
        return nums;
    }
    private static void swap(int []arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}