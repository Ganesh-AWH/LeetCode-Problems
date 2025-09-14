// Last updated: 9/14/2025, 9:16:10 AM
class Solution {
public:
    int maximumGap(vector<int>& nums) {
        if(nums.size()<2){
            return 0;
        }
        sort(nums.begin(),nums.end());
        int maxSum = INT_MIN;
        int sum = 0;
        for(int i=nums.size()-2;i>=0;i--){
            sum = nums[i+1] - nums[i];
            maxSum = std::max(maxSum,sum); 
        }

        return maxSum;
    }
};