// Last updated: 9/14/2025, 9:07:33 AM
class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int count = 0;
        int n = hours.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int hrs = hours[i] + hours[j];
                if(hrs % 24 == 0){
                    count++;
                }
            }
        }
        
        return count;
    }
}