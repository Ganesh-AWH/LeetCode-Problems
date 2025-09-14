// Last updated: 9/14/2025, 9:11:48 AM
class Solution {
    // static class Pair{
    //     int value;
    //     int count;
    //     Pair(int value,int count){
    //         this.value = value;
    //         this.count = count;
    //     }
    // }
    public int sumSubarrayMins(int[] arr) {
        //Optimal solution -> using monotonic stack and its frequency
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        int []left = new int[arr.length];
        int []right = new int[arr.length];
        //finding next smallest element and calculating frequecy of greater numbers to left
        for(int i=0;i<arr.length;i++){
            int freq = 1;
            while(!stack.isEmpty() && stack.peek().getKey() >= arr[i]){
                Pair<Integer,Integer> p = stack.pop();
                freq += p.getValue();
            }
            left[i] = freq;
            stack.push(new Pair<>(arr[i],freq));
        }
        stack.clear();
        //finding next smallest element and calculating frequency of greater numbers to right
        for(int i=arr.length-1;i>=0;i--){
            int freq = 1;
            //don't use >= because two times it will be caluculated
            while(!stack.isEmpty() && stack.peek().getKey() > arr[i]){
                Pair<Integer,Integer> p = stack.pop();
                freq += p.getValue();
            } 
            right[i] = freq;
            stack.push(new Pair<>(arr[i],freq));
        }
        //formula left[i] * right[i] * arr[i];
        long ans = 0;
        final int mod = 1000000007;
        for(int i=0;i<arr.length;i++){
           ans += (long) left[i] * right[i] % mod * arr[i] % mod;
           ans %= mod;
        }

        return (int)ans;
    }
}