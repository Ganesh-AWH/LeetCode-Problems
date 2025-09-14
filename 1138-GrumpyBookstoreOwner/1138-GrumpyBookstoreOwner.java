// Last updated: 9/14/2025, 9:11:06 AM
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;
        int n = customers.length;
        for(int i=0; i<n; i++){
            satisfied += grumpy[i] == 0 ? customers[i] : 0;
        }
        int maxAns = 0;
        for(int i=0; i<n; i++){
            int temp = satisfied;
            for(int j=i; j<i+minutes && j<n; j++){
                temp += grumpy[j] == 1 ? customers[j] : 0;
            }
            maxAns = Integer.max(maxAns, temp);
        }
        return maxAns;
    }
}