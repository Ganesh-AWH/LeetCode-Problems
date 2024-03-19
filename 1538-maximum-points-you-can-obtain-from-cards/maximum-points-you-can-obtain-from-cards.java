class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //first find sum of all the elements 
        int total = 0;
        for(int i:cardPoints){
            total += i;
        }
        int left = 0;
        int right = 0;
        int windowSum = 0 ;
        int n = cardPoints.length;
        int max = 0;
        while(right < n){
            windowSum += cardPoints[right];
            //this is used to find the sum of k elements by removing n-k elements sum
            if(right - left + 1 == n - k){
                max = Integer.max(max,total - windowSum);
                windowSum -= cardPoints[left];
                left++;
            }
            right++;
        }
        return max==0?total:max; // k equal to size of the array
    }
}