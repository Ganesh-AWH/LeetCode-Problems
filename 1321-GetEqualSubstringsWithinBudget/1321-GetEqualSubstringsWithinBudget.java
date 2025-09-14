// Last updated: 9/14/2025, 9:10:40 AM
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        //first find the difference of the ascii of the characters
        //e.g. s=abcd , t=bcdf 
        //difference = 1 1 1 2
        //use sliding window approach to find the max length within maxcost 
        //for the difference dont store it in any extra array calculate by pointing
        int maxLength = Integer.MIN_VALUE;
        int currentCost = 0;
        int l=0;
        int r=0;
        //two pointer approach
        while(r<s.length()){
            currentCost += Math.abs(s.charAt(r) - t.charAt(r));
            while(currentCost > maxCost){
                currentCost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
            maxLength = Integer.max(maxLength,r-l+1);
            r++;
        }
        return maxLength;
    }
}