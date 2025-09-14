// Last updated: 9/14/2025, 9:08:16 AM
class Solution {
    public int pivotInteger(int n) {
        int totalSum = (n*(n+1))/2;
        int currSum = 0;

        for(int i=n;i>=0;i--){
            currSum += i;

            if(totalSum == currSum) return i;

            else totalSum-=i;
        }

        return -1;
    }
}