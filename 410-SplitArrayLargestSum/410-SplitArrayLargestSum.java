// Last updated: 9/14/2025, 9:14:13 AM
class Solution {
    public int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i: nums){
            max = Integer.max(max, i);
            sum += i;
        }

        int low = max;
        int high = sum;
        int ans = 0;
        while(low<=high){
            int mid = (high - low)/2 + low;
            if(countSplit(nums, mid, k) <= k){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }
    public static int countSplit(int []arr, int sum, int k){
        int count = 1;
        int sumLoad = 0;
        for(int i: arr){
            if(sumLoad + i > sum){
                count++;
                sumLoad = i;
            }else{
                sumLoad += i;
            }
        }
        return count;
    }
}