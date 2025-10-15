class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        findSubset(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    public static void findSubset(int i, int []arr, List<Integer> temp, List<List<Integer>> ans){
        if(i>=arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        //pick the element
        temp.add(arr[i]);
        findSubset(i+1, arr, temp, ans);
    
        //not picking the element
        temp.remove(temp.size()-1);
        int next = i+1;
        //skipping the duplicate element 
        while(next<arr.length && arr[next] == arr[i]) next++;

        findSubset(next, arr, temp, ans);
    }
}