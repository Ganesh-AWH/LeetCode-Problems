// Last updated: 9/14/2025, 9:17:20 AM
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,ans,new ArrayList<>(),0);
        return ans;
    }
    private static void helper(int []arr,List<List<Integer>> ans,List<Integer> temp,int index){
        if(!ans.contains(temp))
            ans.add(new ArrayList<>(temp));
        for(int i=index;i<arr.length;i++){
            temp.add(arr[i]);
            helper(arr,ans,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}