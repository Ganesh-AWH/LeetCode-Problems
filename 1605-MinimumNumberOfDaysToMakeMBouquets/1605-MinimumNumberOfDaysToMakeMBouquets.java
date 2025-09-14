// Last updated: 9/14/2025, 9:09:55 AM
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i:bloomDay){
            min = Integer.min(min,i);
            max = Integer.max(max,i);
        }

        int s = min;
        int e = max;
        int ans = -1;
        while(s<=e){
            int mid = s + (e - s)/2;

            if(isPossible(bloomDay,mid,m,k)){
                ans = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return ans;
    }
    private static boolean isPossible(int []arr,int day,int m,int k){
        int count = 0;
        int boquets = 0;

        for(int i:arr){
            if(i<=day){
                count++;
            }else{
                boquets += (count/k);
                count = 0;
            }
        }
        boquets += (count/k);
        return boquets>=m;
    }
}