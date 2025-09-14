// Last updated: 9/14/2025, 9:18:50 AM
int removeDuplicates(int* nums, int numsSize){
         int count = 1;
         for(int i=1;i<numsSize;i++){
             if(nums[i-1]!=nums[i]){
                 nums[count++]=nums[i];
             }
         }
         return count;
}