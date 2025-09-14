// Last updated: 9/14/2025, 9:10:53 AM
class Solution {
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        int x=0,y=1,z=1;
        for(int i=3;i<=n;i++){
            int temp=x+y+z;
            x=y;
            y=z;
            z=temp;
        }
        return z;
    }
}