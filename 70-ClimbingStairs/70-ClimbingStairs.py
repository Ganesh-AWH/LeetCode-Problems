# Last updated: 9/14/2025, 9:17:48 AM
class Solution:
    def climbStairs(self, n: int) -> int:
        if n==1:
            return 1
        if n==2:
            return 2
        a,b,c=1,2,0
        for i in range(3,n+1):
            c=a+b
            b=c
            a=c-a
        return c