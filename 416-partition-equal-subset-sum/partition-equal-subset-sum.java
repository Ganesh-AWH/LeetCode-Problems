class Solution {
    public boolean canPartition(int[] nums) {
        // Subset sum equal to target (DP- 14) do this sum to understand 
        int sum = 0;
        for(int i:nums) sum+= i;
        //there is no possible of division if sum is odd
        if(sum % 2 != 0) return false;
        //if half sum is subset then remaining will also get the same sum 
        sum = sum / 2;
        return isSubsetSum(nums.length,nums,sum);
    }
    public boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        //tabulation solution with space optmization
        boolean []prev = new boolean[sum+1];
        //base case conversion
        // if(target == 0) return 1; this case is converted
        prev[0] = true;
        // if(index == 0){
        //     return arr[0] == target ? 1 : 0;
        // } this case is converted
        if(arr[0]<=sum)
            prev[arr[0]] = true;
        
        for(int i=1;i<N;i++){
            boolean []curr = new boolean[sum+1];
            curr[0] = true;
            for(int target=0;target<=sum;target++){
                boolean notTake  = prev[target];
                boolean take = false;
                if(arr[i] <= target){
                    take = prev[target-arr[i]];
                }
                curr[target] = take || notTake;
            }
            prev = curr;
        }
        return prev[sum];
    }
}