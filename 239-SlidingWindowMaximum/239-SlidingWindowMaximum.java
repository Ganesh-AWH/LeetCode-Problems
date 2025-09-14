// Last updated: 9/14/2025, 9:15:12 AM
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //solve the problem using double ended queue since we have remove or add element from front and last
        Deque<Integer> deq = new ArrayDeque<>();
        int n = nums.length;
        int []ans = new int[n-k+1];
        int x = 0;
        for(int i=0;i<nums.length;i++){
            //remove the elements that are out of range k
            while(!deq.isEmpty() && deq.peek() == i-k){
                //removing index from head
                deq.poll();
            }
            
            //remove the elements that are smaller in queue
            while(!deq.isEmpty() && nums[deq.peekLast()] <= nums[i]){
                //removing index from tail
                deq.pollLast();
            }

            deq.offer(i);

            if(i>=k-1){
                ans[x++] = nums[deq.peek()];
            }
        }
        return ans;
    }
}