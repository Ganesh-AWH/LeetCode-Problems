// Last updated: 9/14/2025, 9:19:18 AM
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || numRows>=s.length()) return s;

        int len = s.length();
        List<StringBuilder> li = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            li.add(new StringBuilder());
        }

        int rows = 0;
        int step = 1;
        for(char c:s.toCharArray()){
            li.get(rows).append(c);
            rows+= step;
            if(rows == 0 || rows == numRows-1){
                step = step * -1;
            }
        }

        StringBuilder ans = new StringBuilder();

        for(StringBuilder x:li){
            ans.append(x);
        }
        return ans.toString();
    }
}