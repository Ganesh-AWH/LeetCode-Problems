// Last updated: 9/14/2025, 9:14:12 AM
class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        //reverse the array
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
        int count=1,prev=nums[0];
        for(i=1;i<nums.length;i++){
            if(prev!=nums[i]){
                count+=1;
                prev=nums[i];
            }
            if(count==3){
                return nums[i];
            }
        }
        return nums[0];
    }
}