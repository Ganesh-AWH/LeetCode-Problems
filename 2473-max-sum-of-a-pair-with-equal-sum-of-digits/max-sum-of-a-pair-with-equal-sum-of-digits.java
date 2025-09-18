class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;

        for(int num:nums){
            int digits = getDigits(num);
            if(map.containsKey(digits)){
                res = Integer.max(res, map.get(digits) + num);
                map.put(digits, Integer.max(map.get(digits), num));
            }else{
                map.put(digits, num);
            }
        }
        return res;
    } 
    public static int getDigits(int n){

        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}