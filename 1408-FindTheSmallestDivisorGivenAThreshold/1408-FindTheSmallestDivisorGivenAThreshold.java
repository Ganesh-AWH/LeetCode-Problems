// Last updated: 9/14/2025, 9:10:28 AM
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        //optimal solution
        int max = 1000000;
        // for(int i:nums){
        //     max = Integer.max(max,i);
        // }
        int s = 1;
        int e = max;
        int ans = 0;
        while(s<=e){
            int mid = s + (e - s)/2;
            if(isPossible(nums,mid,threshold)){
                ans = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return ans;
    }
    private static boolean isPossible(int []arr,int div,int limit){
        int ans = 0;

        for(int i:arr){
            ans += (int)Math.ceil((double)i/(double)div);
        }
        return ans<=limit;
    }
}