// Last updated: 9/14/2025, 9:08:14 AM
class Solution {
    public int maximumCount(int[] nums) {
        //find starting postive index 
        //Use binary search to find that index
        if(nums[0]==0 && nums[nums.length-1]==0) return 0;  
        int negativeCount = findNegativeIndex(nums)+1;
        int positiveCount = nums.length - findPositiveIndex(nums);
        System.out.println(negativeCount+" "+positiveCount);

        return negativeCount >= positiveCount ? negativeCount : positiveCount;
    }
    private static int findNegativeIndex(int []arr){
        int s = 0;
        int e = arr.length-1;
        int negativeIndex = -1;
        while(s<=e){
            int mid = s + (e - s)/2;
            if(arr[mid]<0){
                negativeIndex = mid;
                s = mid +1;
            }else
                e = mid - 1;
        }
        return negativeIndex;
    }
    private static int findPositiveIndex(int []arr){
        int start = 0;
        int end = arr.length-1;
        int positiveIndex = arr.length;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]>0){
                positiveIndex = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        return positiveIndex;
    }
}