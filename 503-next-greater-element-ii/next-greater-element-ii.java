class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int len = n * 2 - 1;
        Stack<Integer> stack = new Stack<>();
        int []ans = new int[n];
        //Hint : 1 2 1 | 1 2 1  use next greater element concept with modulo operator
        for(int i=len;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i%n]){
                stack.pop();
            }
            if(i<n){
                if(stack.isEmpty()){
                    ans[i] = -1;
                }else{
                    ans[i] = stack.peek();
                }
            }
            stack.push(nums[i%n]);
        }

        return ans;
    }
}