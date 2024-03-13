class Solution {
    public int largestRectangleArea(int[] heights) {
        //better approach 
        //monotonic stack and its frequecy
        int []left = new int[heights.length];
        int []right = new int[heights.length];
        Stack<Pair<Integer,Integer>> stack = new Stack<>();

        //finding left buildings that are greater than current building
        for(int i=0;i<heights.length;i++){
            int freq = 1;
             while(!stack.isEmpty() && stack.peek().getKey() >= heights[i]){
                Pair<Integer,Integer> p = stack.pop();
                freq += p.getValue();
            }
            left[i] = freq;
            stack.push(new Pair<>(heights[i],freq));
        }

        // finding right buildings that are greater than current building 
        stack.clear();
        for(int i=heights.length-1;i>=0;i--){
            int freq = 1;
            while(!stack.isEmpty() && stack.peek().getKey() > heights[i]){
                Pair<Integer,Integer> p = stack.pop();
                freq += p.getValue();
            }
            right[i] = freq;
            stack.push(new Pair<>(heights[i],freq));
        }

        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int area = (left[i] + right[i] - 1) * heights[i];
            maxArea = Integer.max(maxArea,area);
        }

        return maxArea;
    }
}