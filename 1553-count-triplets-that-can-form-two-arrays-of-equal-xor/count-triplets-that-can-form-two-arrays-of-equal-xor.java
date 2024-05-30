class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length+1;
        int []prefix_xor = new int[n];
        prefix_xor[0] = 0;

        for(int i=1;i<n;i++){
            prefix_xor[i] = prefix_xor[i-1] ^ arr[i-1];
        }

        int res = 0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(prefix_xor[i] == prefix_xor[j]){
                    res += j - i - 1;
                }
            }
        }

        return res;
    }
}