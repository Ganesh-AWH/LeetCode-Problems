// Last updated: 9/14/2025, 9:13:25 AM
class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == 'A'){
                absent++;
                if(absent == 2) return false;
                late = 0;
            }else if(c == 'L'){
                late++;
                if(late >= 3) return false;
            }else{
                late = 0;
            }
        }
        return true;
    }
}