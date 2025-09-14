// Last updated: 9/14/2025, 9:13:37 AM
class Solution {
    public boolean detectCapitalUse(String word) {
        char arr[]=word.toCharArray();
        int count=0;
        int cap_count=Character.isUpperCase(arr[0])?1:0;
        // to check all characters are upper
        for(int i=0;i<arr.length;i++){
            if(Character.isUpperCase(arr[i])){
                count+=1;
            }
        }
        if(count==word.length()){
            return true;
        }
        count=0;
        // to check all characters are lower
         for(int i=0;i<arr.length;i++){
            if(Character.isLowerCase(arr[i])){
                count+=1;
            }
        }
        if(count==word.length()){
            return true;
        }

        //to check only first character is upper
        boolean t=Character.isUpperCase(arr[0])?true:false;
        for(int i=1;i<arr.length;i++){
            if(Character.isUpperCase(arr[i])){
                t=false;
                break;
            }
        }
        return t;
    }
}