# Last updated: 9/14/2025, 9:15:07 AM
class Solution:
    def addDigits(self, num: int) -> int:
        s = 0
        while num!=0 or s>9:
            if num==0:
                num = s
                s = 0
            s += num%10
            num = num//10
        return s