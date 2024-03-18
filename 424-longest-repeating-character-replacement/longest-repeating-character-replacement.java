class Solution {
    public int characterReplacement(String s, int k) {
        //solving with time complexity O(26.n)
        //using two pointers and sliding approach
        int l = 0;
        int r = 0;
        int length = 0;
        int []freq = new int[26];
        while(r<s.length()){
            char c = s.charAt(r);
            freq[c-'A']++;
            while((r-l+1) - (findMaxi(freq)) > k){
                char x = s.charAt(l);
                freq[x-'A']--;
                l++;
            }
            length = Integer.max(length,r-l+1);
            r++;
        }
        return length;
    }
    public int findMaxi(int []freq){
        int max = 0;
        for(int i:freq){
            max = Integer.max(max,i);
        }
        return max;
    }
}