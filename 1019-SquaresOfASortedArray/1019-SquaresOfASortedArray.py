# Last updated: 9/14/2025, 9:11:32 AM
import math
#using two pointers
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
            l,r=0,len(nums)-1
            res=[0 for i in nums]
            for i in range(len(nums)-1,-1,-1):
                if abs(nums[l])>abs(nums[r]):
                    res[i]=nums[l]*nums[l]
                    l+=1
                else:
                    res[i]=nums[r]*nums[r]
                    r-=1
            return res
