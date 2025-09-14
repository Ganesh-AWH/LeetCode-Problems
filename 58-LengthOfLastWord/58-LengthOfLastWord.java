// Last updated: 9/14/2025, 9:18:02 AM
class Solution {
    public int lengthOfLastWord(String s) {
        int i=s.length(),length=0;
        while(i>0){
            i-=1;
            if(s.charAt(i)!=' '){
                length++;
            }else if(length>0){
                return length;
            }
        }
        return length;   
    }
}