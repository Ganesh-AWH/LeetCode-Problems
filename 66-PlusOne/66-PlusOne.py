# Last updated: 9/14/2025, 9:17:55 AM
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        for i in range(len(digits)-1,-1,-1):
            if digits[i]<9:
                digits[i]+=1
                return digits
            digits[i]=0
        digits.insert(0,1)
        return digits