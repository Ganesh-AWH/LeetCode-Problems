class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // index as Hashtable
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int a = Math.abs(nums[i]);
            nums[a-1] *=-1;
        } 
        System.out.println(Arrays.toString(nums));
        for(int i:nums){
            int a = Math.abs(i);
            if(nums[a-1]>0){
                ans.add(a);
                nums[a-1]*=-1;
            }
        }
        return ans;
    }
}