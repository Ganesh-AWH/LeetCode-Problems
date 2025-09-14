// Last updated: 9/14/2025, 9:17:27 AM
class Solution {
    public int largestRectangleArea(int[] heights) {
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