# Last updated: 9/14/2025, 9:16:06 AM
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()
        return nums[len(nums)//2]