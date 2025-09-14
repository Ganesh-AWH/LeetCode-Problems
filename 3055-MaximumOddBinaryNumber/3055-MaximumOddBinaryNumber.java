// Last updated: 9/14/2025, 9:07:50 AM
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int oneCount = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') oneCount++;
        }
        StringBuilder ans = new StringBuilder();
        oneCount--;
        for(int i=oneCount;i>0;i--){
            ans.append("1");
        }
        for(int i=oneCount;i<=s.length()-2;i++) ans.append("0");
        
        return ans.append("1").toString();
    }
}