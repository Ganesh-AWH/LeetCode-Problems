// Last updated: 9/14/2025, 9:15:35 AM
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> q(nums.begin(),nums.end());
        while(k!=1){
            q.pop();
            k-=1;
        }
        return q.top();
    }
};