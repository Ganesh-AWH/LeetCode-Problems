// Last updated: 9/14/2025, 9:18:56 AM
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //optimal solution
        //TC: app O(N^3)
        //SC: O(1)
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(i!=0 && nums[i-1]==nums[i]) continue;
            for(int j=i+1;j<len;j++){
                if(j>i+1 && nums[j-1]==nums[j]) continue;
                int k = j+1;
                int l = len-1;
                while(k<l){
                    long sum = nums[i] + nums[j];
                    sum+= nums[k];
                    sum+= nums[l];
                    if(sum<target){
                        k++;
                    }else if(sum>target){
                        l--;
                    }else{
                        ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                        while(k<l && nums[k] == nums[k-1]) k++;
                        while(k<l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }
        return ans;
    }
}