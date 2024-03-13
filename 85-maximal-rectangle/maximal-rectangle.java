class Solution {
    public int maximalRectangle(char[][] matrix) {
        //to solve this problem use largest histogram concept
        //for each column count how many ones present that is considered as a height of the building
        int []heights = new int[matrix[0].length];
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }
            int currMax = histogram(heights);
            max = Integer.max(currMax,max);
        }

        return max;
    }
    private static int histogram(int[] heights) {
        //optimal solution finding left max and right max in one pass
        //stack stores index values
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<=heights.length;i++){
            while(!stack.isEmpty() && (i == heights.length || heights[stack.peek()] >= heights[i])){
                int height = heights[stack.pop()];
                // int leftIndex = stack.isEmpty() ? : 0 : stack.top();
                // int rightIndex = i;
                int width = 0;
                if(stack.isEmpty()){
                    width = i;
                }else{
                    //rightIndex - leftIndex
                    width = i - stack.peek() - 1;
                }
                maxArea = Integer.max(maxArea,height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}