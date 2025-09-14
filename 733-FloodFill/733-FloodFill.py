# Last updated: 9/14/2025, 9:12:47 AM
class Solution:
    # DFS algorithm
    def color_change(self,image: List[List[int]], sr: int, sc: int,src: int, color: int):

        if(sr<0 or sr>=len(image) or sc<0 or sc>=len(image[0]) or image[sr][sc]!=src):
            return
        image[sr][sc]=color

        self.color_change(image,sr-1,sc,src,color)
        self.color_change(image,sr+1,sc,src,color)
        self.color_change(image,sr,sc-1,src,color)
        self.color_change(image,sr,sc+1,src,color)

    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image[sr][sc]==color:
            return image

        rows=len(image)
        cols=len(image[0])
        src=image[sr][sc]

        self.color_change(image,sr,sc,src,color)

        return image