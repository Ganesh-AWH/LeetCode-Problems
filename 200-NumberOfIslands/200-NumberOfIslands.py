# Last updated: 9/14/2025, 9:15:53 AM
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def count_island(grid: List[List[str]],r: int,c: int):
            if(r<0 or r>=len(grid) or c<0 or c>=len(grid[0]) or grid[r][c]!="1"):
                return
            grid[r][c]="2"
            count_island(grid,r-1,c)
            count_island(grid,r+1,c)
            count_island(grid,r,c-1)
            count_island(grid,r,c+1)

        rows=len(grid)
        cols=len(grid[0])
        count=0
        for i in range(rows):
            for j in range(cols):
                if grid[i][j]=="1":
                    count_island(grid,i,j)
                    count+=1
        return count