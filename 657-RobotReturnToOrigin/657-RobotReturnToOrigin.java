// Last updated: 9/14/2025, 9:13:03 AM

// U= 1,D = -1,R= 2,L = -2
class Solution {
    public boolean judgeCircle(String moves) {
        int up=0,down=0,right=0,left=0;
        for(char c:moves.toCharArray()){
            if(c=='U'){
                up++;
            }else if(c=='D'){
                down++;
            }else if(c == 'R'){
                right++;
            }else if(c == 'L'){
                left++;
            }
        }
        return (up==down && right==left);
    }
}