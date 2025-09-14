// Last updated: 9/14/2025, 9:10:15 AM
class Solution {
    public int numberOfSubstrings(String s) {
        //sliding window approach
        int left = 0;
        int right = 0;
        int occurrences = 0;
        int n = s.length();
        //frequency array
        int []abc = new int[3];
        while(right < n){
            abc[s.charAt(right) - 'a']++;
            //these condition refers all 'abc' occurs from left to right 
            //so  n - right also the contains these 'abc'
            while(abc[0] > 0 && abc[1] > 0 && abc[2] > 0){
                occurrences += n - right;
                abc[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return occurrences;
    }
}