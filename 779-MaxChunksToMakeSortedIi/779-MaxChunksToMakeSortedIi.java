// Last updated: 9/14/2025, 9:12:35 AM
class Solution {
    public int maxChunksToSorted(int[] arr) {
        if(arr.length == 1) return 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(stack.peek()<=arr[i]){
                stack.push(arr[i]);
                max = arr[i];
            }else{
                while(!stack.empty() && stack.peek()>arr[i]){
                    stack.pop();
                }
                stack.push(max);
            }
        }
        return stack.size();
        
    }
}