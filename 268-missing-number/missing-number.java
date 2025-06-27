class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n+1)/2;
        int arrSum = 0;
        for(int i: nums) arrSum += i;

        return total - arrSum; 
    }
}