// Last updated: 9/14/2025, 9:18:41 AM
class Solution {
    public int strStr(String str, String key) {
        int l1=str.length();
        int l2=key.length();
        if(l1<l2){
            return -1;
        }
        int i=0,j=0,w=0,k=0,g=0;
        while(true){
            if(w==(l1-l2)+1){
                break;
            }
            if(str.charAt(w+j)==key.charAt(j)){
                 if(k==0){
                     g=w;
                     k=1;
                 }
                 j++;
            }else{
                w++;
                j=0;
                k=0;
            }
            if(j==l2){
                return g;
            }
        }
        return -1;
    }
}
//butsad