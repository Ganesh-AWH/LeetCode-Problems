// Last updated: 9/14/2025, 9:10:35 AM
class Solution {
    public int balancedStringSplit(String s) {
        int rCount = 0;
        int count = 0;
        for(char c:s.toCharArray()){
            if(c == 'R') rCount++;
            if(c == 'L') rCount--;
            if(rCount == 0) count++; 
        }
        return count;
    }
}