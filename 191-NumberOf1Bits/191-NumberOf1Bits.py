# Last updated: 9/14/2025, 9:15:55 AM
class Solution:
    def hammingWeight(self, n: int) -> int:
        count=0
        while n!=0:
            if n&1:
                count+=1
            n=n>>1
        return count
