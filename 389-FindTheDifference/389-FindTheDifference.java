// Last updated: 9/14/2025, 9:14:22 AM
class Solution {
    public char findTheDifference(String s, String t) {
        int ans = 0;
        for(char c:s.toCharArray()) ans ^= c;
        for(char c:t.toCharArray()) ans ^= c;
        return (char)ans;
    }
}