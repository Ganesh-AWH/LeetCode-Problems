// Last updated: 9/14/2025, 9:14:39 AM
class Solution {
    public int minPatches(int[] nums, int n) {
        int howmanytopatch=0;
        long elementToSearch=1;
         
         int lengthpointer=0;
        while(elementToSearch<=n){
      if(lengthpointer<nums.length && elementToSearch>=nums[lengthpointer]){
        elementToSearch+=nums[lengthpointer];
        lengthpointer++;
      }
      else{
      howmanytopatch++;
      elementToSearch+=elementToSearch;
      }
        }
        return howmanytopatch;
        
    }
}