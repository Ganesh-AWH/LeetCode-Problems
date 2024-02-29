class Solution {
    public int lengthOfLongestSubstring(String s) {
        //base condition
        if(s.length()==0 || s == null) return 0;

        Set<Character> set = new HashSet<>();
        int i=0;
        int j=0;
        int max=Integer.MIN_VALUE;
        while(i<s.length()){
            char c = s.charAt(i);
            while(set.contains(c)){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(c);
            max = Math.max(max,i-j+1);
            i++;
        }

        return max;

    }
}