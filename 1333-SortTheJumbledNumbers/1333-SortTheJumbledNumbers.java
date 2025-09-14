// Last updated: 9/14/2025, 9:10:37 AM
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer []ans = new Integer[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i] = nums[i];
            int x = convert(String.valueOf(nums[i]), mapping);
            map.put(nums[i], x);
        } 
        Arrays.sort(ans, (a, b) -> map.get(a) - map.get(b));
        int []ans1 = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans1[i] = ans[i];
        }
        return ans1;
    }
    public static int convert(String num, int []mapping){
        int ans = 0;
        for(int i=0; i<num.length(); i++){
            int d = num.charAt(i) - '0';
            ans = ans * 10 + mapping[d];
        }
        return ans;
    }
}