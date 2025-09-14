// Last updated: 9/14/2025, 9:15:44 AM
// import java.util.*;
class Solution {
    public int countPrimes(int n) {
        //seive of eratosthenes algorithm
        if(n==0 || n==1) return 0;

        //is prime boolean array initialized all as true
        boolean []isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        //change 1 and 2 as false
        isPrime[0] = false;
        isPrime[1] = false;

        int sq = (int)Math.sqrt(n);

        for(int i=2;i<=sq;i++){
            //change multiples of the prime number 
            for(int j=i+i;j<=n;j+=i){
                isPrime[j] = false;
            }
        }

        //count the no of false
        int count = 0;
        for(int i=0;i<n;i++){
            if(isPrime[i]) count++;
        }
        return count;
    }
}