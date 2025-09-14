// Last updated: 9/14/2025, 9:09:50 AM
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink = 0;
        while(numBottles >= numExchange){
            drink += numExchange;
            numBottles -= numExchange;

            numBottles++;
        } 

        return drink + numBottles;
    }
}