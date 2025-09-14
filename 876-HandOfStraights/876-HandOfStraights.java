// Last updated: 9/14/2025, 9:12:08 AM
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!= 0) return false;
        Arrays.sort(hand);
        for(int i=0;i<n;i++){
            if(hand[i]>=0){
                if(!findSuccesor(hand,groupSize,n,i)){
                    return false;
                }
            }
        }

        return true;
    }
    public boolean findSuccesor(int []hand,int groupSize,int n,int i){
        int f = hand[i]+1;
        int count = 1;
        hand[i] = -1;
        i++;
        while(i<n && count<groupSize){
            if(hand[i] == f){
                f = hand[i] + 1;
                hand[i] = -1;
                count++;
            }
            i++;
        }
        
        return count == groupSize;
    }
}