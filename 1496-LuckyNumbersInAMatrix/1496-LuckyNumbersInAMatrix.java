// Last updated: 9/14/2025, 9:10:10 AM
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        //determining minimum elements in the matrix row wise
        for(int i=0;i<m;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                }
            }
            map.put(min,1);
        }

        //determining maximum elements in the matrix column wise

        for(int i=0;i<n;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<m;j++){
                if(matrix[j][i] > max){
                    max = matrix[j][i];
                }
            }

            if(map.containsKey(max)){
                if(!ans.contains(max)){
                    ans.add(max);
                }
            }
            else map.put(max,1);
        }  

        // System.out.println(map);

        return ans;
    }
}