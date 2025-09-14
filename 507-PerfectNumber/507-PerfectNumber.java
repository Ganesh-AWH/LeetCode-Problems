// Last updated: 9/14/2025, 9:13:41 AM
class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num<=0){
            return false;
        }
        int factSum=0;
        int m=num/2;
        for(int i=1;i<=m;i++){
            if(num%i==0){
                factSum+=i;
            }
            if(factSum>num){
                return false;
            }
        }
        return factSum==num;
    }
}