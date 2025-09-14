// Last updated: 9/14/2025, 9:07:10 AM
class Solution {
    public int maximumLength(int[] nums) {
        //case 1 and case 2 every even and every odd
        int odd = 0;
        int even = 0;
        for(int i: nums){
            if(i % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        //max of case1 and case2
        int max = Integer.max(odd, even);
        //for case 3 sub0 = odd + sub1 = even + sub2 = odd;
        //false = odd and true = even
        max = Integer.max(max, helper(nums, false)); 
        max = Integer.max(max, helper(nums, true));

        return max;
    }
    public int helper(int []nums, boolean flag){
        int len = 0;
        for(int i=0; i<nums.length; i++){
            //go for odd
            if(flag && nums[i]%2 == 1){
                len++;
                flag = false;
            }else if(!flag && nums[i]%2 == 0){
                len++;
                flag = true;
            }
        }

        return len;
    }
}