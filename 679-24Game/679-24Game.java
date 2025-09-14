// Last updated: 9/14/2025, 9:12:57 AM
class Solution {
    public boolean judgePoint24(int[] cards) {
        //convert into double 
        double []newCards = new double[cards.length];
        for(int i=0;i<cards.length;i++){
            newCards[i] = (double) cards[i];
        }
        return helper(newCards,newCards.length);
    }
    private static boolean helper(double []cards,int n){
        //the final answer
        if(n == 1){
            //not precise answer will so use this
            if(Math.abs(cards[0]-24.0) < 0.1){
                return true;
            }
            return false;
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                //to take two number and to store one result from the cards array
                double []newCards = new double[n-1];
                int index = 0;
                for(int k=0;k<n;k++){
                    if(k!=i && k!=j){
                        newCards[index++] = cards[k];
                    }
                }

                //perform six operations because sub and divide is not commutative
                double []ans = new double[]{cards[i]+cards[j],cards[i]-cards[j],cards[j]-cards[i],cards[i]*cards[j],cards[i]/cards[j],cards[j]/cards[i]};
                for(double x:ans){
                    //store that ans in last index of new array
                    newCards[index] = x;
                    if(helper(newCards,n-1)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}