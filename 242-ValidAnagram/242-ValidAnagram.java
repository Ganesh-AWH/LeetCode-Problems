// Last updated: 9/14/2025, 9:15:08 AM
class Solution {
    public boolean isAnagram(String s, String t) {
        int []freq = new int[26];
        if(s.length() != t.length()) return false;

        for(int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            freq[c1-'a']++;
            freq[c2-'a']--;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0) return false;
        }
        return true;
    }
}