# Last updated: 9/14/2025, 9:15:26 AM
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n==0:
            return False

        while n%2==0:
            n//=2
        return n==1 