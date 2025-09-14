// Last updated: 9/14/2025, 9:13:31 AM
class Solution {
    public static void reverse(char []arr,int s,int e){
        while(s<e){
            char temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
    public String reverseStr(String s, int k) {
        char []arr = s.toCharArray();
        int len = arr.length;
        for(int i=0;i<len;i+=2*k){
            int start = i;
            //Boundary condition
            int end = Math.min(i+k-1,len-1);
            reverse(arr,start,end);
        }
        return new String(arr);
    }
}