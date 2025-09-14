# Last updated: 9/14/2025, 9:11:14 AM
class Solution:
    def isArmstrong(self, n: int) -> bool:
        length=len(str(n))
        temp,res=n,0
        while n>0:
            res+=(n%10)**length
            n//=10
        return temp==res