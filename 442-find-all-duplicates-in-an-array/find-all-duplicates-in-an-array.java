class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // index as Hashtable
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int val = Math.abs(nums[i]);
            if(nums[val-1] < 0){
                ans.add(val);
            }else{
                nums[val-1] *= -1;
            }
        }
        return ans;
    }
}