// Last updated: 9/14/2025, 9:18:25 AM
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates,target,0,ans,new ArrayList<>(),0);
        return ans;
    }
    private static void helper(int []arr,int target,int sum,List<List<Integer>> ans,List<Integer> temp,int index){
        if(sum > target){
            return;
        }
        if(sum == target){
            // if(!ans.contains(temp))
            ans.add(new ArrayList<>(temp));
            return;
        }

        //exclude part
        for(int i=index;i<arr.length;i++){
            if(i!=index && arr[i] == arr[i-1]) continue;
            sum += arr[i];
            temp.add(arr[i]);
            helper(arr,target,sum,ans,temp,i+1);
            sum -= arr[i];
            temp.remove(temp.size()-1);
        }
    }
}