# Last updated: 9/14/2025, 9:12:37 AM
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start,end=0,len(nums)-1
        while(start<=end):
            mid=start+(end-start)//2
            if nums[mid]==target:
                return mid
            elif nums[mid]>target:
                end=mid-1
            else:
                start=mid+1
        return -1
