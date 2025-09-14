// Last updated: 9/14/2025, 9:16:02 AM
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while(columnNumber>0){
            // if question is 1 then we add it to 'A' which results in 'B' so better minus one to the column
            int remainder = (columnNumber-1) % 26;
            char c =(char) (65+remainder);
            ans.append(c);
            columnNumber = (columnNumber-1)/26;
        }
        return ans.reverse().toString();
    }
}