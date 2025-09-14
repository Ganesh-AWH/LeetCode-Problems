// Last updated: 9/14/2025, 9:10:06 AM
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandie = Integer.MIN_VALUE;
        for(Integer x : candies){
            maxCandie = Integer.max(x,maxCandie);
        }
        List<Boolean> ans = new ArrayList<>();
        for(Integer x : candies){
            if((x+extraCandies)>=maxCandie) ans.add(true);
            else ans.add(false);
        }

        return ans;
    }
}