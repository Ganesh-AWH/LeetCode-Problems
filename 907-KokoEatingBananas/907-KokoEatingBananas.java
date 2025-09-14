// Last updated: 9/14/2025, 9:11:55 AM
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minHours = 1;
        int max = Integer.MIN_VALUE;

        for(int i:piles){
            max = Integer.max(i,max);
        }

        //Binary search 
        int s = 1;
        int e = max;

        while(s<=e){
            int mid = s + (e - s)/2;
            int hours = findHours(piles,mid);
            if(hours<=h){
                minHours = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }

        return minHours;
    }
    private static int findHours(int []piles,int hourly){
        int hours = 0;

        for(int i:piles){
            hours += Math.ceil((double)i/(double)hourly);
        }
        return hours;
    }
    //Tc : 2O(n)*log(maxElement)
}