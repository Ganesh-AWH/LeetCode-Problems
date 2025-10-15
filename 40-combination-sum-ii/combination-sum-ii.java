class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
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

        if(arr[i]<=target){
            temp.add(arr[i]);
            findCombination(i+1, arr, target-arr[i], temp, ans);
            temp.remove(temp.size()-1);
        }

        int next = i+1;
        while(next<arr.length && arr[next] == arr[i]) next++;
        findCombination(next, arr, target, temp, ans);
    }
}