// Last updated: 9/14/2025, 9:12:58 AM
class Solution {
    public boolean checkValidString(String s) {
        /*
            () -> consider there is no * in string what would be the approach you 
            create one variable if '(' var++ else var--;
            
            (*) -> because * there is two possibilities one is either open bracket or close bracket
            thats why we use leftMax, leftMin note leftMax should not be zero
        */
        int leftMax = 0;
        int leftMin = 0;

        for(char c:s.toCharArray()){
            if(c == '('){
                leftMax++;
                leftMin++;
            }else if(c == ')'){
                leftMax--;
                leftMin--;
            }else if(c == '*'){
                leftMax++;
                leftMin--;
            }

            if(leftMax < 0) return false;

            if(leftMin < 0) leftMin = 0;
        }

        return leftMin == 0;
    }
}