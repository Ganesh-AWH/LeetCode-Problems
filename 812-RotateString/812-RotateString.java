// Last updated: 9/14/2025, 9:12:18 AM
class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length()==goal.length() && (s+s).contains(goal);
    }
}