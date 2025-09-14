// Last updated: 9/14/2025, 9:18:40 AM
class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int size = nums.size();
        
        int bPoint = -1;
        for(int i=size-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                bPoint = i;
                break;
            }
        }

        if(bPoint == -1){
            reverse(nums.begin(),nums.end());
            return;
        }

        for(int i=size-1;i>=0;i--){
            if(nums[bPoint]<nums[i]){
                swap(nums[bPoint],nums[i]);
                break;
            }
        }

        reverse(nums.begin()+bPoint+1,nums.end());
        
    }
};