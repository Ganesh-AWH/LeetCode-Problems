// Last updated: 9/14/2025, 9:09:45 AM
class Solution {
    public int maxDistance(int[] position, int m) {
        //This question is like aggressive cows in striver sde sheet
        //optimal solution
        // pattern max(min)
        Arrays.sort(position);
        int n = position.length;
        int s = 1;
        int e = position[n-1]  - position[0];
        int ans = 0;
        while(s<=e){
            int mid = s + (e - s)/2;
            if(isPossible(position,m,mid)){
                ans = mid;
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return ans;
    }
    private static boolean isPossible(int []arr,int m,int distance){
        int ballsCount = 1;
        int lastPosition = arr[0];

        for(int i=1;i<arr.length;i++){
            if((arr[i] - lastPosition)>=distance){
                ballsCount++;
                lastPosition = arr[i];
            }
        }
        return ballsCount>=m;
    }
}