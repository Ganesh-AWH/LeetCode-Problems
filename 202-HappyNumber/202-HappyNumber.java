// Last updated: 9/14/2025, 9:15:48 AM
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=1 && !set.contains(n)){
            set.add(n);
            n = nextGenerate(n);
        }
        return n==1;
    }
    private static int nextGenerate(int n){
        int total = 0;
        while(n>0){
            int x = n%10;
            total+=x*x;
            n/=10;
        }
        return total;
    }
}