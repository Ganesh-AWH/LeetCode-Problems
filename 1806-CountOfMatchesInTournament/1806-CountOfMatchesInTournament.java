// Last updated: 9/14/2025, 9:09:23 AM
class Solution {
    public int numberOfMatches(int n) {
        int matches = 0;
        while(n!=1){
            if(n%2==0){
                matches += n/2;
                n/=2;
            }else{
                matches += n/2;
                n = (n/2)+1;
            }
        }
        return matches;
    }
}