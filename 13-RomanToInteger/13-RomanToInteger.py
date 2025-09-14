# Last updated: 9/14/2025, 9:19:13 AM
class Solution:
    def romanToInt(self, s: str) -> int:
        romans={'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000}
        last=len(s)-1
        tot=romans.get(s[-1])
        last_value=tot
        for i in reversed(range(len(s)-1)):
            current_value=romans.get(s[i])
            if current_value<last_value:
                tot-=current_value
            else:
                tot+=current_value
            last_value=current_value
        return tot