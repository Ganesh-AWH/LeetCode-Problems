# Last updated: 9/14/2025, 9:09:02 AM
class Solution:
    def getLucky(self, s: str, k: int) -> int:
        string=""
        t=""
        for i in s:
            t+=str(ord(i)-96)
        
        p=k-1
        while p>=0:
            sum=0
            for i in t:
                sum+=int(i)
            t=str(sum)
            p-=1
        return int(t)
