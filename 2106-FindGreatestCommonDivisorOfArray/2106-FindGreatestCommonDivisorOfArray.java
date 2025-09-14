// Last updated: 9/14/2025, 9:08:58 AM
class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i:nums){
            max = Integer.max(i,max);
            min = Integer.min(i,min);
        }
        return GCD(max,min);
    }
    private static int GCD(int n1,int n2){
        int rem = 0;
        while(n2!=0){
            rem = n1%n2;
            n1 = n2;
            n2 = rem;
        }
        return n1;
    }
}