// Last updated: 9/14/2025, 9:18:22 AM
class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length-1;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int result = 0;
        while(l<=r){
            if(height[l]<=height[r]){
                if(height[l]>=leftMax){
                    leftMax = height[l];
                }
                result+= leftMax - height[l];
                l++;
            }else{
                if(height[r]>=rightMax){
                    rightMax = height[r];
                }
                result+= rightMax - height[r];
                r--;
            }
        }
        return result;
    }
}