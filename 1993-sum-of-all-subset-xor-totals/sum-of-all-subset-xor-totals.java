class Solution {
    public int subsetXORSum(int[] nums) {
        int []ans = new int[1];
        helper(nums,0,new ArrayList<>(),ans);            
        return ans[0];
    }
    public void helper(int []nums,int index,List<Integer> temp,int []sum){
        int xor = 0;
        for(int i=0;i<temp.size();i++){
            xor = xor ^ temp.get(i);
        }
        sum[0] += xor;
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            helper(nums,i+1,temp,sum);
            temp.remove(temp.size()-1);
        }
    }
}

