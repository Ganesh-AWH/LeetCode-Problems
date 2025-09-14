// Last updated: 9/14/2025, 9:14:03 AM
class Solution {
    public int arrangeCoins(int n) {
           long start = 0;
           long end = n;
           long res = 0;
           while(start <= end){
               long mid = start + (end - start)/2;
               long coins = mid * (mid + 1) / 2;
               if(coins > n){
                   end = mid - 1;
               } else{
                   start = mid + 1;
                   res = Math.max(mid , res);
               }
           }
           return (int)res;
    }
}