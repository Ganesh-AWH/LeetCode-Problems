// Last updated: 9/14/2025, 9:09:57 AM
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int arr[] = new int[n*2];
        int i = 0;
        int x = 0;
        for(int j = n ; j < nums.length ; j++){
            arr[x++] = nums[i++];
            arr[x++] = nums[j];
        }
        System.out.println(n);
        return arr;
    }
}

//TC : O(N)
//SC : O(N)