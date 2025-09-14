// Last updated: 9/14/2025, 9:13:46 AM
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums.length,target,nums);
    }
    public int countPartitions(int n, int d, int[] arr) {
        // code here
        int total = 0;
        for(int i:arr) total += i;
        
        if(total - d < 0 || (total-d)%2!=0) return 0;
        
        return perfectSum(arr,n,(total-d)/2);
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    //recursion solution
	    int []prev = new int[sum+1];
	    if(arr[0] == 0) prev[0] = 2;
	    else prev[0] = 1;
	    
	    if(arr[0] != 0 && arr[0]<=sum) prev[arr[0]] = 1;

	    
	    for(int index=1; index<n; index++){
	        int []curr = new int[sum+1];
	        for(int target=0;target<=sum;target++){
	            int notPick = prev[target];
        	    int pick = 0;
        	    if(arr[index] <= target){
        	        pick = prev[target-arr[index]];
        	    }
        	    curr[target] = (pick + notPick);
	        }
	        prev = curr;
	    }
	    return prev[sum];
	} 
}