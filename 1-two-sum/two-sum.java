public class Pair{
    int first = 0;
    int second = 0;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Pair []p = new Pair[nums.length];
        for(int i=0; i<nums.length; i++){
            p[i] = new Pair(nums[i], i);
        }
        Arrays.sort(p, (i,j) -> {return i.first - j.first;});
        /*
            or we can use integer.compare function to compare
            Array.sort(p, (i,j) -> Integer.compare(i.first - i.first));
         */
        int i = 0;
        int j = nums.length-1;
        int sum = 0;
        while(i < j){
           sum =  p[i].first + p[j].first;
           if(sum > target) j--;
           else if(sum < target) i++;
           else{
                return new int[]{p[i].second, p[j].second};
           }
        }

        return new int[]{0,0};
    }
}