// Last updated: 9/14/2025, 9:19:22 AM
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int halfPortion = (n1 + n2 + 1)/2;
        int low = 0;
        int high = n1;
        while(low <= high){
            int m1 = low + (high - low)/2;
            int m2 = halfPortion - m1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if(m1 < n1) r1 = nums1[m1];
            if(m2 < n2) r2 = nums2[m2];
            if(m1-1 >= 0) l1 = nums1[m1-1];
            if(m2-1 >= 0) l2 = nums2[m2-1];

            if(l1<=r2 && l2<=r1){
                if(n%2==1){
                    return (double)Integer.max(l1,l2);
                }else{
                    return (Integer.max(l1,l2)+Integer.min(r1,r2))/2.0;
                }
            }
            else if(l1>r2){
                high = m1-1;
            }else{
                low = m1+1;
            }
        }
        return 0.0;
    }
}