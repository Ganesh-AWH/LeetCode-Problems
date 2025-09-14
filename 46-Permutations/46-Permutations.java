// Last updated: 9/14/2025, 9:18:17 AM
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //solving whith swaps
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,ans);
        return ans;
    }
    private static void helper(int []arr,int index,List<List<Integer>> ans){
        if(index == arr.length){
            List<Integer> temp = new ArrayList<>();
            for(int i:arr){
                temp.add(i);
            }
            ans.add(temp);
            return;
        }
        
        for(int i=index;i<arr.length;i++){
            swap(arr,i,index);
            helper(arr,index+1,ans);
            swap(arr,i,index);
        }
    }
    private static void swap(int []arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}