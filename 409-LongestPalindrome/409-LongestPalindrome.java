// Last updated: 9/14/2025, 9:14:16 AM
class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
                count+=2;
            }else{
                set.add(s.charAt(i));
            }
        }

        if(!set.isEmpty()){
            count+=1;
        }

        return count;
    }
}