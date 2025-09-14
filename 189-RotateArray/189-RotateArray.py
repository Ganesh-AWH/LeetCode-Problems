# Last updated: 9/14/2025, 9:16:08 AM
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k=k%len(nums)
        nums.reverse()
        start,end=0,k-1
        while(start<end):
            nums[start],nums[end]= nums[end],nums[start]
            start+=1
            end-=1
        start,end=k,len(nums)-1
        while(start<end):
            nums[start],nums[end]= nums[end],nums[start]
            start+=1
            end-=1