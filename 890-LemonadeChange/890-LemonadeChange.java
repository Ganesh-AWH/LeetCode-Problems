// Last updated: 9/14/2025, 9:12:04 AM
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int i=0;i<bills.length;i++){
            //if they give 5 rs then we no need to give any change
            if(bills[i] == 5){
                five++;
            }
            //if they give 10 rs ten we need to give 5rs to them
            else if(bills[i] == 10){
                five--;
                ten++;
            }
            //if they give 15rs then we need to check we have ten rs or 3 five rs
            else if(bills[i] == 20){
                if(ten>0){
                    ten--;
                    five--;
                }else{
                    five -= 3;
                }
            }

            if(ten<0 || five<0) return false;
        }

        return true;
    }
}