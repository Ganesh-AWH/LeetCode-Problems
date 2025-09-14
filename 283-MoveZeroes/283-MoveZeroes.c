// Last updated: 9/14/2025, 9:14:59 AM
void moveZeroes(int* nums, int numsSize){
      int index=0;
      for(int i=0;i<numsSize;i++){
          if(nums[i]!=0){
              nums[index++]=nums[i];
          }
      }
      for(int i=index;i<numsSize;i++){
          nums[i]=0;
      }
}