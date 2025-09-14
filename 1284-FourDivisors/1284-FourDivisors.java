// Last updated: 9/14/2025, 9:10:49 AM
class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int i:nums){
            sum += isFourDivisors(i);
        }
        return sum;
    }
    private static int isFourDivisors(int n){
        int sum = n;
        int count = 1;
        if(n!=1){
            sum+=1;
            count++;
        }
        int sqrt = (int)Math.sqrt(n);
        for(int i=2;i<=sqrt;i++){
            if(n%i==0){
                sum+=i;
                count++;
                if(n/i!=i){
                    sum += n/i;
                    count++;
                }
            }
            if(count>4) return 0;
        }
        return count==4?sum:0;
    }
}