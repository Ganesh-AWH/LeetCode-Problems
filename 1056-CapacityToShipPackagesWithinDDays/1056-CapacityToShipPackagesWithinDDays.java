// Last updated: 9/14/2025, 9:11:18 AM
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //optimal solution
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i:weights){
            max = Integer.max(max,i);
            sum += i;
        }

        //using binary search
        int s = max;
        int e = sum;
        int ans = 0;
        while(s<=e){
            int mid = s + (e - s)/2;
            int d = findRequiredDays(weights,mid);
            if(d<=days){
                ans = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return ans;
    }
    private static int findRequiredDays(int []arr,int capacity){
        int load = 0;
        int days = 1;
        for(int i:arr){
            if((load+i)>capacity){
                days++;
                load = i;
            }else{
                load += i;
            }
        }
        return days;
    }
}