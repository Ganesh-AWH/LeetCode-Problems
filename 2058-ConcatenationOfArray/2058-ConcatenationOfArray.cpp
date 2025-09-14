// Last updated: 9/14/2025, 9:09:05 AM
class Solution {
public:
    vector<int> getConcatenation(vector<int>& nums) {
        // int size = nums.size();
        vector<int> ans;
        for(int i=0;i<nums.size();i++){
            ans.push_back(nums[i]);
        }
        for(int i=0;i<nums.size();i++){
            ans.push_back(nums[i]);
        }

        return ans;
    }
};