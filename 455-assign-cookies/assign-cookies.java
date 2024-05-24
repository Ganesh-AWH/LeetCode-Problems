class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0;
        int r = 0;
        int count = 0;
        while(l<g.length){
            while(r<s.length && g[l] > s[r]){
                r++;
            }
            if(r<s.length){
                count++;
                r++;
                l++;
            }else{
                break;
            }
        }

        return count;
    }
}