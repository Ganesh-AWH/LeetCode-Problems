# Last updated: 9/14/2025, 9:18:09 AM
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        i,length=len(s),0
        while i>0:
            i-=1
            if s[i]!=' ':
                length+=1
            elif length>0:
                return length
        return length