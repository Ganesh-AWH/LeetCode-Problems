# Last updated: 9/14/2025, 9:10:14 AM
class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        temp = []
        for i in range(len(mat)):
            temp.append([mat[i].count(1),i])
        temp.sort()

        l=[]
        for i in range(k):
            l.append(temp[i][1])
        return l