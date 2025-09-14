// Last updated: 9/14/2025, 9:09:10 AM
class Solution {
    public int subsetXORSum(int[] nums) {
        int []sum = new int[1];
        helper(nums,0,new ArrayList<>(),sum);
        return sum[0];
    }
    public void helper(int []nums,int index,List<Integer> temp,int []sum){
        int xor = 0;
        for(Integer i:temp){
            xor = xor ^ i;
        }
        sum[0] += xor;

        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            helper(nums,i+1,temp,sum);
            temp.remove(temp.size()-1);
        }
    }
}