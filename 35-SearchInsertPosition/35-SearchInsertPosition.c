// Last updated: 9/14/2025, 9:18:35 AM
int searchInsert(int* nums, int numsSize, int target){
          int start=0,end=numsSize-1;
          if(nums[0]>target){
              return start;
          }else if(nums[numsSize-1]<target){
               return numsSize;
          }
          while(start<=end){
              int mid=start+(end-start)/2;
              if(nums[mid]==target){
                  return mid;
              }else if(nums[mid]>target){
                  end=mid-1;
              }else{
                  start=mid+1;
              }
          }
          return start;
}