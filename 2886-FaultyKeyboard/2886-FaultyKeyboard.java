// Last updated: 9/14/2025, 9:07:58 AM
class Solution {
    public String finalString(String s) {
        //use Stting Builder to solve

        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c == 'i'){
                if(sb.length()>0) sb.reverse();
            }else{
                sb.append(c);
            }
        }

        return sb.toString();
    }
}