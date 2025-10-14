class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans =  new ArrayList<>();
        findSubset(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    public static void findSubset(int i, int []arr, List<Integer> temp, List<List<Integer>> ans){
        if(i >= arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        //take 
        temp.add(arr[i]);
        findSubset(i+1, arr, temp, ans);
        //not take
        temp.remove(temp.size()-1);
        findSubset(i+1, arr, temp, ans);
    }  
}