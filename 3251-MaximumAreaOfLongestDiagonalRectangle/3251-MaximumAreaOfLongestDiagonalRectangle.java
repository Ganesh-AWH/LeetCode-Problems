// Last updated: 9/14/2025, 9:07:47 AM
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxarea = 0;
        int maxi = 0;
        for(int []dimension: dimensions){
            int l = dimension[0];
            int b = dimension[1];
            int area = l * b;
            int diagonalLength = (l*l + b*b);
            if(diagonalLength > maxi){
                maxi = diagonalLength;
                maxarea = area;
            }else if(diagonalLength == maxi){
                maxarea = Integer.max(maxarea, area);
            }
        }
        return maxarea;
    }
}