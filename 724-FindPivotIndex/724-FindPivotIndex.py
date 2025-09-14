# Last updated: 9/14/2025, 9:12:49 AM
class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        s,left_sum=sum(nums),0
        for i in range(len(nums)):
            if left_sum==(s-nums[i]-left_sum):
                return i
            left_sum+=nums[i]
        return -1