// Last updated: 9/14/2025, 9:13:44 AM
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //use next greatest element concept and hasing 
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        //use next greatest element concept for nums2 
        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            //there no next greatest element for that index
            if(stack.isEmpty()){
                map.put(nums2[i],-1);
            }else{
                map.put(nums2[i],stack.peek());
            }
            stack.push(nums2[i]);
        } 

        //update the nums1 array to find answer
        int []ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }

        return ans;
    }
}