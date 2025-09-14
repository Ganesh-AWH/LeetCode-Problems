// Last updated: 9/14/2025, 9:17:22 AM
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // two pointers approach
        if(m==0){
            nums1[0] = nums2[0];
        }
        int index = m+n-1;
        while(m>0 && n>0){
            if(m>0 && nums2[n-1]>nums1[m-1]){
                nums1[index] = nums2[n-1];
                n--;
            }else{
                nums1[index] = nums1[m-1];
                m--;
            }
            index--;
        }
        while(n>0){
            nums1[index--] = nums2[n-1];
            n--;
        }
    }
}