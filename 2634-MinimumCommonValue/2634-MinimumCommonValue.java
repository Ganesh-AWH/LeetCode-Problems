// Last updated: 9/14/2025, 9:08:13 AM
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        //solving using two pointers approach
        int i=0;
        int j=0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]) return nums1[i];

            else if(nums1[i] < nums2[j]) i++;
            else j++;
        }   

        return -1;
    }
}