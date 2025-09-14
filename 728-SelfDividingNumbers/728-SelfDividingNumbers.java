// Last updated: 9/14/2025, 9:12:43 AM
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(i<=9) ans.add(i);
            else if(i%10!=0)
                if(isSelfDividing(i)) ans.add(i);
        }
        return ans;
    }
    private static boolean isSelfDividing(int n){
        int temp = n;
        while(temp>0){
            int digit = temp % 10;
            if(digit==0 || n%digit!=0) return false;
            temp/=10;
        }
        return true;
    }
}