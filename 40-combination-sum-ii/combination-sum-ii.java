class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
    public static void findCombination(int index, int []arr, int target, List<Integer> temp, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index; i<arr.length; i++){
            if(i!=index && arr[i] == arr[i-1]) continue;
            if(target>=arr[i]){
                temp.add(arr[i]);
                findCombination(i+1, arr, target-arr[i], temp, ans);
                temp.remove(temp.size()-1);
            }
        }
    }
}