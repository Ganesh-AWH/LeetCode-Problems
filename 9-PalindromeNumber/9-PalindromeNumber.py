# Last updated: 9/14/2025, 9:19:19 AM
class Solution:
    def isPalindrome(self, x: int) -> bool:
        l=str(x)
        n=l[::-1]
        if l==n:
            return True
        else:
            return False
