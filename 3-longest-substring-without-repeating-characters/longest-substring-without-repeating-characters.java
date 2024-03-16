class Solution {
    public int lengthOfLongestSubstring(String s) {
        //better approach 
        //two pointers approach
        int l = 0;
        int r = 0;
        int length = 0;
        Set<Character> set = new HashSet<>();
        while(r<s.length()){
            char c = s.charAt(r);
            while(set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            length = Integer.max(length,r-l+1);
            r++;
        }

        return length;
    }
}