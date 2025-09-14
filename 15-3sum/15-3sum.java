// Last updated: 9/14/2025, 9:19:01 AM
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        //sort the array so that two pointers approach can be used
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            if(i != 0 && nums[i-1] == nums[i]) continue;
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                }else if(sum > 0){
                    k--;
                }else{
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j-1] == nums[j]) j++;
                    while(j< k && nums[k+1] == nums[k]) k--;
                }
            }
        }

        return ans;
    }
}