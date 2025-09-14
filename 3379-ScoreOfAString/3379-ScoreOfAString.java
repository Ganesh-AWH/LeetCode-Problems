// Last updated: 9/14/2025, 9:07:38 AM
class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        for(int i=0;i<s.length()-1;i++){
            score += Math.abs(s.charAt(i) - s.charAt(i+1)); 
        }
        return score;
    }
}