class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        findSubset(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    public static void findSubset(int index, int []arr, List<Integer> temp, List<List<Integer>> ans){
        if(index>=arr.length){
            if(!ans.contains(temp))
                ans.add(new ArrayList<>(temp));
            return;
        }

        
        temp.add(arr[index]);
        findSubset(index+1, arr, temp, ans);
        
        temp.remove(temp.size()-1);
        findSubset(index+1, arr, temp, ans);
    }
}