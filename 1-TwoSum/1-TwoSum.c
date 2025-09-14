// Last updated: 9/14/2025, 9:19:28 AM
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int isContains(int *arr,int start,int end,int target){
    for(int i=start;i<end;i++){
        if(arr[i] == target){
            return i;
        }
    }
    return -1;
}
int* twoSum(int* nums, int numsSize, int target, int* returnSize){
      int *p = (int *) malloc(2*sizeof(int));
      *returnSize=2;
      for(int i=0;i<numsSize;i++){
          int x=target-nums[i];
          int a=isContains(nums,i+1,numsSize,x);
          if(a!=-1){
              p[0]=i;
              p[1]=a;
              break;
          }
      }

      return p;

}
