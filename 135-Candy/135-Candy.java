// Last updated: 9/14/2025, 9:16:38 AM
class Solution {
    public int candy(int[] ratings) {
        //divide problem into two cases 
        //case - 1 left to right
        //case - 2 right to left

        int []result = new int[ratings.length];
        //assigining all child with one chocolate
        Arrays.fill(result,1);
        //case -1
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                result[i] = result[i-1] + 1;
            }
        }

        //case -2
        int total = 0;
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                result[i] = Integer.max(result[i],result[i+1]+1);
            }
        }

        for(int i:result) total += i;

        return total;
    }
}