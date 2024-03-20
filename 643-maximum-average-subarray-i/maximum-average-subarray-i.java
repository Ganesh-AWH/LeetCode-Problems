class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        //summing the k elements
        for(int i=0;i<k;i++){
            sum += nums[i];
        }

        int left = 0;
        int right = k;
        int maxSum = sum;
        while(right < nums.length){
            sum -= nums[left++];
            sum += nums[right++];

            maxSum = Integer.max(sum,maxSum);
        }

        return (double)maxSum/k;
    }
}