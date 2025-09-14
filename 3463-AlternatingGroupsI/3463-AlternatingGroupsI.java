// Last updated: 9/14/2025, 9:07:19 AM
class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int p1 = 1;
        int len = colors.length;
        int count = 0;
        for(;p1<len; p1++){
            int r = (p1-1) % len;
            int f = (p1+1) % len;
            if(colors[r]!=colors[p1] && colors[f]!=colors[p1]){
                count++;
            }
            // System.out.println(r +" "+ p1 +" "+ f);
        }
        if(colors[len-1] != colors[0] && colors[0]!=colors[1]) count++;
        return count;
    }
}