// Last updated: 9/14/2025, 9:17:38 AM
class Solution {
    public void sortColors(int[] nums) {
          int zi = 0 , ti = nums.length-1;
          int i = 0,t;
          while(i <= ti){
              if(nums[i] == 0){
                  t = nums[i];
                  nums[i] = nums[zi];
                  nums[zi] = t;
                  i++;
                  zi++; 
              }
             else if(nums[i] == 2){
                  t = nums[i];
                  nums[i] = nums[ti];
                  nums[ti] = t;
                  ti--;
              }
              else{
                  i++;
              }
          }
    }
}