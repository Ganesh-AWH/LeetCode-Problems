// Last updated: 9/14/2025, 9:16:07 AM
class Solution {
    public int maximumGap(int[] nums) {
        int maxGap = 0;
        if(nums.length<2) return 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //step -1
        for(int i:nums){
            min = Integer.min(min,i);
            max = Integer.max(max,i);
        }

        int bucketSize = (int)Math.ceil((double)(max-min)/(n-1));

        int minBucket[] = new int[n-1];
        int maxBucket[] = new int[n-1];

        Arrays.fill(minBucket,Integer.MAX_VALUE);
        Arrays.fill(maxBucket,-1);

        for(int i=0;i<n;i++){
            if(nums[i]==min || nums[i]==max) continue;

            int bIndex = (nums[i]-min)/bucketSize;
            minBucket[bIndex] = Integer.min(minBucket[bIndex],nums[i]);
            maxBucket[bIndex] = Integer.max(maxBucket[bIndex],nums[i]);
        }

        for(int i=0;i<n-1;i++){
            if(maxBucket[i]==-1) continue;

            maxGap = Integer.max(maxGap,minBucket[i]-min);
            min = maxBucket[i];
        }
        maxGap = Integer.max(maxGap,max-min);

        return maxGap;
    }
}
//Pegion Hole algorithm
//step-1 find the minimum and maximum value

/*step-2 
elements left = n-2
create n-1 buckets
bucket size = ceil((max-min)/n-1)

step-3
place elements
elementIndex = (nums[i]-min)/bucketsize;
*/