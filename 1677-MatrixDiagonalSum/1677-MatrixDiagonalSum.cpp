// Last updated: 9/14/2025, 9:09:44 AM
class Solution {
public:
    int diagonalSum(vector<vector<int>>& mat) {
        int sum = 0;
        int row = mat.size();
        int j=mat[0].size()-1;
        for(int i=0;i<row;i++){
            sum+=mat[i][i];
            if(i!=j)
              sum+=mat[i][j];
            j--;
        }
        return sum;
    }
};