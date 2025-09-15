// Last updated: 9/15/2025, 9:21:09 PM
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length-1];

        //tracks first string
        int i = 0;
        //tracks second string
        int j = 0;

        int index = 0;
        while(i<first.length() && j<last.length()){
            char c1 = first.charAt(i);
            char c2 = last.charAt(j);
            if(c1 == c2){
                index++;
            }else{
                break;
            }
            i++;
            j++;
        }

        return index == 0?"": first.substring(0, index);
    }
}