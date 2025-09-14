// Last updated: 9/14/2025, 9:07:12 AM
class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        int x = helper(red, blue);
        int y = helper(blue, red);
        return Integer.max(x, y);
    }
    public int helper(int red, int blue){
        int x = 0;
        while(red >= x+1){
            x++;
            red -= x;
            if(blue>=x+1){
                x++;
                blue -= x;
            }else{
                break;
            }
        }

        return x;
    }
}