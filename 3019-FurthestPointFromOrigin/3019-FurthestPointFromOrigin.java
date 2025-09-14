// Last updated: 9/14/2025, 9:07:53 AM
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int lcount = 0;
        int dcount = 0;
        int rcount = 0;
        
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L'){
                lcount++;
            }else if(moves.charAt(i)=='R'){
                rcount++;
            }else{
                dcount++;
            }
        }
        int max = Integer.max(lcount,rcount);
        int min = Integer.min(lcount,rcount);
        
        return (max+dcount)-min;
    }
}