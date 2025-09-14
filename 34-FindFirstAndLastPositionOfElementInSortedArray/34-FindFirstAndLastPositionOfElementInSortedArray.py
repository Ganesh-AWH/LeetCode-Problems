# Last updated: 9/14/2025, 9:18:33 AM
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start = 0 
        end = len(nums) 
        flag = 0

        while start < end:
            if(nums[start] == target):
                flag+=1
                break
            start+=1
        
        end-=1
        while end >= 0:
            if(nums[end] == target):
                flag+=1
                break
            end-=1
        
        if flag==0:
            return [-1,-1]
        else:
            return [start,end] 