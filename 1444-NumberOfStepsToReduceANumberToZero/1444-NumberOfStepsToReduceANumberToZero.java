// Last updated: 9/14/2025, 9:10:20 AM
class Solution {
    public int numberOfSteps(int num) {
        return helper(num,0);
    }
    private static int helper(int num,int count){
        if(num == 0) return count;

        if(num%2 == 0) num/=2;
        else num-=1;

        return helper(num,count+1);
    }
}