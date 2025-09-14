// Last updated: 9/14/2025, 9:08:02 AM
class Solution {
    public int minimumSum(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        //It is like two sum approach
        for(int i=1;n>0;i++){
            int x = k - i;
            
            if(!set.contains(x)){
                set.add(i);
                sum+=i;
                n--;
            }
        }
        return sum;
    }
}
