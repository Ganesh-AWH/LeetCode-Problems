// Last updated: 9/14/2025, 9:17:36 AM
class Solution {
    static void backTrack(List<List<Integer>> result, List<Integer>  temp,int n,int k,int start){
        if(temp.size()==k){
            result.add(new ArrayList(temp));
            return;
        }
        for(int i=start;i<=n;i++){
            temp.add(i);
            backTrack(result,temp,n,k,i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(result,temp,n,k,1);
        return result;
    }
}