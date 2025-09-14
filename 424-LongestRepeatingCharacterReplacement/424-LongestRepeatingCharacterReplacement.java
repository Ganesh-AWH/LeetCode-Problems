// Last updated: 9/14/2025, 9:14:06 AM
class Solution {
    public int characterReplacement(String str, int k) {
        int maxFreq = 0;
        int []freq = new int[26];
        int l = 0;
        int r = 0;
        int length = 0;
        while(r<str.length()){
            char c = str.charAt(r);
            freq[c-'A']++;
            maxFreq = Integer.max(maxFreq,freq[c-'A']);
            while((r-l+1) - maxFreq > k){
                char x = str.charAt(l);
                freq[x-'A']--;
                l++;
            }
            length = Integer.max(length,r-l+1);
            r++;
        }

        return length;
    }
}