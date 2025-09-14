// Last updated: 9/14/2025, 9:13:23 AM
class Solution {
    public void rev(char []narr,int start,int end){
        while(start<end){
            char temp=narr[start];
            narr[start]=narr[end];
            narr[end]=temp;
            start++;
            end--;
        }
    }
    public String reverseWords(String s) {
        int start=0,end=0;
        char arr[]=s.toCharArray();
        for(int i=0;i<arr.length;i++){
                if(arr[i]==' '|| i==arr.length-1){
                    if(i==arr.length-1){
                    rev(arr,start,i);
                    }else{
                        rev(arr,start,i-1);
                    }
                    start=i+1;
                }
        }
        return new String(arr);
    }
}