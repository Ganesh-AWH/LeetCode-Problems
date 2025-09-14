// Last updated: 9/14/2025, 9:07:56 AM
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        //Sorting the array
        Collections.sort(nums); 

        int res = 0 , left = 0,right = nums.size()-1;

        while(left < right){
            int a = nums.get(left) , b = nums.get(right);

            if(a + b < target){
                res += right - left;
                left++;
            }else{
                right--;
            }
        }

        return res;

        //TC : O(N*logN);
        //SC : O(1);
    }
}