class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            pascal.add(generateRow(i));
        }
        return pascal;
    }
    public List<Integer> generateRow(int row){
        List<Integer> ans = new ArrayList<>();
        int res = 1;
        ans.add(1);
        for(int col=1; col<row; col++){
            res = res*(row - col);
            res = res/col;
            ans.add(res);
        }
        return ans;
    }
}