class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {   
        /*
        The intuition behind this algorithm is to count the number of subarrays 
        with at most k distinct elements by using a sliding window approach,
        and then subtracting the count of subarrays with at most (k - 1) distinct elements
        to obtain the count of subarrays with exactly k distinct elements
        */

        return (helper(nums,k) - helper(nums,k-1));
    }
    private int helper(int []nums,int k){
        int count = 0;
        //two pointers 
        int left = 0;
        int right = 0;
        //stores number and its frequecncy
        Map<Integer,Integer> map = new HashMap<>();

        while(right < nums.length){
            int num = nums[right];
            map.put(num,map.getOrDefault(num,0)+1);
            while(map.size() > k){
                int l = nums[left];
                if(map.get(l) == 1){
                    map.remove(l);
                }else{
                    map.put(l,map.get(l)-1);
                }
                left++;
            }
            //counting the subarrays
            count += right - left + 1;
            right++;
        }

        return count;
    }   
}