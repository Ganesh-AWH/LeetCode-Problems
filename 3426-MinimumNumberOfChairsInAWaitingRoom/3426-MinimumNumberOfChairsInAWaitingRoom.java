// Last updated: 9/14/2025, 9:07:32 AM
class Solution {
    public int minimumChairs(String s) {
        int max = Integer.MIN_VALUE;
        int chairs = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'E'){
                chairs++;
            }else{
                chairs--;
            }

            max = Integer.max(max,chairs);
        }
        return max;
    }
}