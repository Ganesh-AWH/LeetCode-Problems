class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        findCombination(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
    public static void findCombination(int i, int []arr, int target, List<Integer> temp, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i>=arr.length){
            return;
        }

        //take if num<=target
        if(arr[i]<=target){
            temp.add(arr[i]);
            findCombination(i, arr, target-arr[i], temp, ans);
            temp.remove(temp.size()-1);
        }

        //not take 
        findCombination(i+1, arr, target, temp, ans);
    }
}