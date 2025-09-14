// Last updated: 9/14/2025, 9:07:30 AM
class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int []freq = new int[51];
        for(int i:nums){
            freq[i]++;
        }
        int xor = 0;
        for(int i=0;i<freq.length;i++){
            if(freq[i]==2){
                xor = xor ^ i;
            }
        }

        return xor;
    }
}