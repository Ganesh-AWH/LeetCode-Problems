class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length-1;
        int score = 0;
        int maxScore = 0;
        while(i<=j){
            if(tokens[i]<=power){
                score++;
                power = power - tokens[i];
                maxScore = Integer.max(score,maxScore);
                i++;
            }
            else if(score >= 1){
                power += tokens[j];
                score--;
                j--;
            }else{
                break;
            }
        }

        return maxScore;
    }
}