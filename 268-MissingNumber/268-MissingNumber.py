# Last updated: 9/14/2025, 9:15:04 AM
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        nums.sort()
        j=0
        for i in nums:
            if j!=i:
                return j
            j+=1
        return j