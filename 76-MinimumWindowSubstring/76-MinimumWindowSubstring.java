// Last updated: 9/14/2025, 9:17:37 AM
class Solution {
    public String minWindow(String s, String t) {
        //moving window so use two pointers 
        //creating two frequency array for string t one is to validate and another is to updation 
        int []freq = new int[256];
        int []curr = new int[256];
        for(char c:t.toCharArray()){
            freq[c]++;
        }

        //two pointers 
        int left = 0;
        int right = 0;
        String ans = "";
        int minLength = Integer.MAX_VALUE;
        while(right<s.length()){
            char c = s.charAt(right);
            curr[c]++;
            while(isValid(curr,freq)){
                //update the ans because the substring is valid
                if(minLength > s.substring(left,right+1).length()){
                    ans = s.substring(left,right+1);
                    minLength = ans.length();
                }
                char l = s.charAt(left);
                curr[l]--;
                left++;
            }
            right++;
        }

        return ans;
    }
    private boolean isValid(int []curr,int []freq){
        for(int i=0;i<256;i++){
            if(freq[i]>0 && curr[i] < freq[i]){
                return false;
            }
        }
        return true;
    }
}