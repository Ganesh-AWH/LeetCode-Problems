// Last updated: 9/14/2025, 9:13:19 AM
class Solution {
    boolean ispermutation(int s1[],int s2[]){
            for(int i=0;i<26;i++){
                if(s1[i]!=s2[i]){
                    return false;
                }
            }
            return true;
    }
    public boolean checkInclusion(String str1, String str2) {
        int len1=str1.length();
        int len2=str2.length();
        
        if(len1>len2){
            return false;
        }

        int s1[]=new int[26];
        int s2[]=new int[26];
        for(int i=0;i<len1;i++){
            s1[str1.charAt(i)-'a']++;
            s2[str2.charAt(i)-'a']++;
        }
        for(int i=0;i<len2-len1;i++){
            if(ispermutation(s1,s2)){
            return true;
            }
            s2[str2.charAt(i)-'a']--;
            s2[str2.charAt(i+len1)-'a']++;
        }
        return ispermutation(s1,s2);
    }
}