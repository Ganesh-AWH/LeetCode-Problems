// Last updated: 9/14/2025, 9:14:33 AM
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        
        for(int i:nums1){
            set.add(i);
        }
        Set<Integer> ans = new HashSet<>();
        for(int i:nums2){
            if(set.contains(i)) ans.add(i);
        }

        int []arr = new int[ans.size()];
        int i = 0;  
        for(int x:ans){
            arr[i++] = x;
        }

        return arr;
    }
}