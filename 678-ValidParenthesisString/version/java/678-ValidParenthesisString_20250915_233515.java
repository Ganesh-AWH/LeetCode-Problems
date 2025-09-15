// Last updated: 9/15/2025, 11:35:15 PM
class Solution {
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;

        //min and max helps to track of range of values for *
        for(char c:s.toCharArray()){
            if(c == '('){
                min++;
                max++;
            }else if(c == ')'){
                min--;
                max--;
            }else if(c == '*'){
                
                min--;
                        // -> [-1, 0, 1]
                max++;
            }
            if(min < 0) min = 0;
            if(max < 0) return false;
        }
        return min == 0;
    }
}