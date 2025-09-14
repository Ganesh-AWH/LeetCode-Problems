// Last updated: 9/14/2025, 9:12:09 AM
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //check condition for top left right bottom
        int x1 = rec1[0],y1 = rec1[1];
        int x2 = rec1[2],y2 = rec1[3];
        int a1 = rec2[0],b1 = rec2[1];
        int a2 = rec2[2],b2 = rec2[3];
        return !(y1>=b2 || b1>=y2 || x1>=a2 || a1>=x2);
    }
}