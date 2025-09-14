# Last updated: 9/14/2025, 9:14:07 AM
class Solution:
    def arrangeCoins(self, n: int) -> int:
        start , end = 0 , n
        res = 0
        while(start <= end):
            mid = start + (end - start) // 2
            coins =  (mid / 2) * (mid + 1)   # n(n+1)/2
            if(coins > n):
                end = mid - 1
            else:
                start = mid + 1
                res = max(mid , res)
        return res