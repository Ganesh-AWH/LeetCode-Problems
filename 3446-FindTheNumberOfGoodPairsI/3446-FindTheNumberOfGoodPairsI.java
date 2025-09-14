// Last updated: 9/14/2025, 9:07:27 AM
class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        for(int i=0;i<nums2.length;i++){
            nums2[i] *= k;
        }

        int count = 0;
        for(int j=0;j<nums2.length;j++){
            for(int i=0;i<nums1.length;i++){
                if(nums1[i]%nums2[j] == 0) count++;
            }
        }

        return count;
    }
}