// Last updated: 9/14/2025, 9:11:27 AM
class Solution {
    public List<Integer> addToArrayForm(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        int carry = 0;
        for(int i=nums.length-1;i>=0;i--){
            sum  = nums[i]+carry;
            if(k>0){
                sum += k%10;
                k/=10;
            }
            carry = sum/10;
            ans.add(0,sum%10);
        }
        while(k>0){
            sum = k%10 + carry;
            ans.add(0,sum%10);
            carry = sum/10;
            k/=10; 
        }
        if(carry!=0){
            ans.add(0,carry);
        }
        return ans;
    }
}