# Last updated: 9/14/2025, 9:16:37 AM
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        res=0
        for i in nums:
            res=res^i
        return res