// Last updated: 9/14/2025, 9:12:27 AM
class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        //optimal solution
        double low = 0;
        double high = 0;

        for(int i=0;i<stations.length-1;i++){
            high = Math.max((double)(stations[i+1]-stations[i]),high);
        }
        
        double diff = 1e-6 ;
        while((high-low)>diff){
            double mid = low + (high - low)/2.0;
            int count = NoOfGasStation(stations,mid);
            if(count>k){
                low = mid;
            }else{
                high = mid;
            }
        }
        return high;
    }
    private static int NoOfGasStation(int []arr,double dist){
        int count = 0;

        for(int i=0;i<arr.length-1;i++){
            int numberInBetween = (int)((arr[i+1] - arr[i]) / dist);
            if ((arr[i+1] - arr[i]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            count += numberInBetween;
        }
        return count;
    }
}