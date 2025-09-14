// Last updated: 9/14/2025, 9:12:03 AM
class Solution {
    public int matrixScore(int[][] grid) {
        //to solve this problem there is two condition
        //first - if the first number in the row is 0 then flip it
        //second - if 0's greater than 1 in column then flip the column

        //solving for condition -1
        for(int i=0;i<grid.length;i++){
            if(grid[i][0] == 0){
                flipRow(grid,i);
            }
        }

        //sloving for condition - 2
        for(int i=1;i<grid[0].length;i++){
            int oneCount = 0;
            for(int j=0;j<grid.length;j++){
                oneCount += grid[j][i];
            }
            if(oneCount < grid.length - oneCount){
                flipColumn(grid,i);
            }
        }

        //find score function
        for(int []mat:grid){
            System.out.println(Arrays.toString(mat));
        }
        int score = findScore(grid);
        return score;
    }
    public void flipColumn(int [][]grid,int col){
        for(int i=0;i<grid.length;i++){
            grid[i][col] = 1 - grid[i][col];
        }
    }
    public void flipRow(int [][]grid,int row){
        for(int i=0;i<grid[0].length;i++){
            grid[row][i] = 1 - grid[row][i];
        }
    }
    public int findScore(int [][]grid){
        int score = 0;
        for(int i=0;i<grid.length;i++){
            int rowScore = 0;
            for(int j=0;j<grid[0].length;j++){
                rowScore = (rowScore << 1) + grid[i][j];
            }
            score += rowScore;
        }

        return score;
    }
}