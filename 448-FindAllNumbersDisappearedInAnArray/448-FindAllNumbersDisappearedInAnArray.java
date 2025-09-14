// Last updated: 9/14/2025, 9:13:59 AM
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // changing its sign for missing elements

        for(int i=0;i<nums.length;i++){
            int a = Math.abs(nums[i]);
            nums[a-1] = - Math.abs(nums[a-1]); 
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]>0) ans.add(i);
        }
        return ans;
    }
}

//TC : O(N)
//SC : O(1)