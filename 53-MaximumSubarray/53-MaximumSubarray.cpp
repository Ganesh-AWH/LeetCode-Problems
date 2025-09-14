// Last updated: 9/14/2025, 9:18:11 AM
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int sum = 0;
        int maxSum = INT_MIN;
        for(int i=0;i<nums.size();i++){
            sum += nums[i];
            maxSum = std::max(sum,maxSum);
            if(sum < 0){
                sum = 0;
            }
        }

        return maxSum;
    }
};