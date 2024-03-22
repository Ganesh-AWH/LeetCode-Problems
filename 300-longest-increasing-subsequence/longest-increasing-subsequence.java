class Solution {
    // refer : https://leetcode.com/bk2444/
    public int lengthOfLIS(int[] nums) {
        //monotonic stack and binary search
        // If we get a number that is greater than the last number in stack: We append it.
        // Otherwise, we find the first number that is >= num and insert in that position
        List<Integer> monoStack = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(monoStack.isEmpty() || monoStack.get(monoStack.size()-1) < num){
                monoStack.add(num);
            }else{
                //binary search to search next greates element int the stack
                int index = 0;
                int s = 0;
                int e = monoStack.size()-1;
                while(s<=e){
                    int mid = (s+e)/2;
                    if(monoStack.get(mid) >= num){
                        index = mid;
                        e = mid-1;
                    }else{
                        s = mid+1;
                    }
                }
                monoStack.set(index,num);
            }
        }

        return monoStack.size();
    }
}