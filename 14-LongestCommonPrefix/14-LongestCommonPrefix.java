// Last updated: 9/14/2025, 9:19:06 AM
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length-1];

        int len = first.length();

        int index = 0;
        for(int i=0;i<len;i++){
            char c1 = first.charAt(i);
            char c2 = last.charAt(i);
            if(c1 == c2){
                index++;
            }else{
                break;
            }
        }

        return index==0?"":first.substring(0,index);
    }
}