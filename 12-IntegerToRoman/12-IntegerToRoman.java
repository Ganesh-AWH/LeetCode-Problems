// Last updated: 9/14/2025, 9:19:08 AM
class Solution {
    static final int []values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    static final String []symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {

        StringBuilder ans = new StringBuilder();
        for(int i=0;i<values.length && num>0;i++){
            while(values[i]<=num){
                num-=values[i];
                ans.append(symbol[i]);
            }
        }

        return ans.toString();
    }
}