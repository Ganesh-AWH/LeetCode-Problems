# Last updated: 9/14/2025, 9:19:29 AM
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        #dicitionary
        for i in range(len(nums)):
            hashmap[nums[i]]=i
        for i in range(len(nums)):
            x=target-nums[i]
            if x in hashmap and hashmap[x]!=i:
                return [i,hashmap[x]]