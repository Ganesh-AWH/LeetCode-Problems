// Last updated: 9/14/2025, 9:18:26 AM
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(candidates,target,0,ans,new ArrayList<>(),0);
        return ans;
    }
    private static void helper(int []arr,int target,int sum,List<List<Integer>> ans,List<Integer> temp,int index){
        if(sum > target) return;

        if(sum == target){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<arr.length;i++){
            sum += arr[i];
            temp.add(arr[i]);
            helper(arr,target,sum,ans,temp,i);

            sum -= arr[i];
            temp.remove(temp.size()-1);
        }
    }
}