// Last updated: 9/14/2025, 9:14:00 AM
class Solution {
    public int compress(char[] chars) {
        int count,x=0;
        for(int i=0;i<chars.length;i+=count){
             count=1;
             while((i+count)<chars.length && chars[i]==chars[i+count]){
                 count++;
             }
             chars[x++]=chars[i];
             if(count>1){
             for(char a:Integer.toString(count).toCharArray()){
                chars[x++]=a;
             }
             }
        }
        return x;
    }
}