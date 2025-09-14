// Last updated: 9/14/2025, 9:11:37 AM
//solve this using two pointer
class Solution {
    public int[] sortedSquares(int[] nums) {
        int l=0,r=nums.length-1,square;
        int []res=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
             if(Math.abs(nums[l])>Math.abs(nums[r])){
                   square=nums[l];
                   l++;
             }else{
                 square=nums[r];
                 r--;
             }
             res[i]=square*square;
        }
        return res;
    }
}