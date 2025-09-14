// Last updated: 9/14/2025, 9:15:33 AM
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(k,n,ans,new ArrayList<>(),0,1);
        return ans;
    }
    private static void helper(int k,int n,List<List<Integer>> ans,List<Integer> temp,int sum,int index){
        if(temp.size() == k){
            if(sum == n){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(n<0){
            return;
        }

        for(int i=index;i<=9;i++){
            sum += i;
            temp.add(i);
            helper(k,n,ans,temp,sum,i+1);

            sum -= i;
            temp.remove(temp.size()-1);
        }
    }
}