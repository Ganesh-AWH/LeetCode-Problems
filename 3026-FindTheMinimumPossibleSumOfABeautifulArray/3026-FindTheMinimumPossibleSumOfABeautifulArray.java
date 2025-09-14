// Last updated: 9/14/2025, 9:07:52 AM
class Solution {
    public long minimumPossibleSum(int n, int target) {
        //Data type is must to watch
        Set<Long> set = new HashSet<Long>();
        long sum = 0;
        
        for(long i=1;n>0;i++){
            long x = target - i;
            if(!set.contains(x)){
                set.add(i);
                sum += i;
                n--;
            }
        
        }
        return sum;
    }
}

//TC : O(N)
//SC : O(N)