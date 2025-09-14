// Last updated: 9/14/2025, 9:09:17 AM
class Solution {
    public int beautySum(String s) {
        //Brute force approach
        // tc = O(n^2)
        int sum = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            int []freq = new int[26];
            for(int j=i;j<len;j++){
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                freq[s.charAt(j)-'a']++;
                for(int k:freq){
                    if(k!=0){
                        max = Integer.max(max,k);
                        min = Integer.min(min,k);
                    }
                }
                sum += (max - min);
            }
        }
        return sum;
    }
}