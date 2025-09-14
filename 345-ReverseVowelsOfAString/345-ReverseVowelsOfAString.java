// Last updated: 9/14/2025, 9:14:34 AM
class Solution {
    static boolean isVowel(char ch){
            ch=Character.toLowerCase(ch);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                return true;
            }
            return false;
    }
    public String reverseVowels(String s) {
        char charArr[] = s.toCharArray();
        int start = 0;
        int end = charArr.length-1;
        while(start < end){
            while(start<end && !isVowel(charArr[start])){
                start++;
            }
            while(end>=0 && !isVowel(charArr[end])){
                end--;
            }
            if(start<end){
                char temp=charArr[start];
                charArr[start] = charArr[end];
                charArr[end] = temp;
                start++;
                end--;
            }
        }
        return new String(charArr);
        
    }
}