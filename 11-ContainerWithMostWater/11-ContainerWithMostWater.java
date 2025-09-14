// Last updated: 9/14/2025, 9:19:12 AM
class Solution {
    public int maxArea(int[] height) {
        //two pointer approach
        int max_area = -1;

        int left = 0;
        int right = height.length-1;

        while(left < right){
            //Calculating area to find capacity

            //width of the cotainer
            int width = right - left;
            //to find height get min value so water cannot be overflow 
            int height1 = Integer.min(height[left],height[right]);
            //area calculation
            int area = width * height1;
            //max area calculation
            max_area = Integer.max(area,max_area);

            //updtaing the height which minimum to find any other possibilities
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }

        //Returing max area 
        return max_area;     
    }
}

//TC : O(N)
//SC : O(1)