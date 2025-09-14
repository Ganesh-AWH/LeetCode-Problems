// Last updated: 9/14/2025, 9:14:51 AM
class Solution {
    public String getHint(String secret, String guess) {
        int []sec = new int[10];
        int []gue = new int[10];

        int bulls = 0;
        int cows = 0;
        for(int i=0;i<secret.length();i++){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if(c1 == c2){
                bulls++;
            }else{
                sec[c1-'0']++;
                gue[c2-'0']++;
            }
        }

        for(int i=0;i<=9;i++){
            cows += Integer.min(sec[i],gue[i]);
        }

        return bulls+"A"+cows+"B";
    }
}