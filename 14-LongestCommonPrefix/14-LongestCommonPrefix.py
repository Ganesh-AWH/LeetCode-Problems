# Last updated: 9/14/2025, 9:19:11 AM
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs)==0:
            return ""
        prefix=strs[0]
        for i in range(len(strs)):
            while(strs[i].find(prefix)!=0):
                prefix=prefix[0:len(prefix)-1]
                if len(prefix)==0:
                    return ""
        return prefix   

