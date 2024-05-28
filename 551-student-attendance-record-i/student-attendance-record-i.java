class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        int consecutiveLates = 0;
        int previousLateIndex = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == 'A') absent++;
            if(c == 'L' && (i-1 == previousLateIndex || previousLateIndex == Integer.MIN_VALUE)){
                previousLateIndex = i;
                consecutiveLates++;
                if(consecutiveLates==3) break;
            }else{
                consecutiveLates = 0;
                previousLateIndex = Integer.MIN_VALUE;
            }
        }
        System.out.println(consecutiveLates);
        return absent < 2 && consecutiveLates < 3;
    }
}