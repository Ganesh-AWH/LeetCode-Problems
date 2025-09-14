# Last updated: 9/14/2025, 9:19:25 AM
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #variables
        l=[]
        left,res=0,0
        for right in range(0,len(s)):
            while s[right] in l:
                l.remove(s[left])
                left+=1
            l.append(s[right])
            res=max(res,right-left+1)
        return res
