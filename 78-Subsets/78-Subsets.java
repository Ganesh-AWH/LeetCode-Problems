// Last updated: 9/14/2025, 9:17:34 AM
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,new ArrayList<>(),ans);

        return ans;
    }
    public void helper(int []arr,int index,List<Integer> temp,List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));

        for(int i=index;i<arr.length;i++){
            temp.add(arr[i]);
            helper(arr,i+1,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
}