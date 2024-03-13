class Solution {
    //to solve this problem refer this idea : https://leetcode.com/spandanx/
    public long subArrayRanges(int[] nums) {
        int []leftMinimus = new int[nums.length];
        int []rightMinimus = new int[nums.length];
        findMinimus(nums,leftMinimus,rightMinimus);

        int []leftMaximus = new int[nums.length];
        int []rightMaximus = new int[nums.length];
        findMaximus(nums,leftMaximus,rightMaximus);
        long ans = 0;
        //sum of maimum side occurrence and minimum side occurence multiply by that number 
        for(int i=0;i<nums.length;i++){
            long maximum = leftMaximus[i] * rightMaximus[i];
            long minimum = leftMinimus[i] * rightMinimus[i];
            ans += (maximum - minimum) * nums[i];
        }
        return ans;
    }

    private static void findMinimus(int []arr,int []left,int []right){
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        //find the next smallest element and calculate its frequecy of greatest element to the left
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
        //find the next smallest element and calculate its frequecy of greatest element to the right
        for(int i=arr.length-1;i>=0;i--){
            int freq = 1;
            while(!stack.isEmpty() && stack.peek().getKey() > arr[i]){
                Pair<Integer,Integer> p = stack.pop();
                freq += p.getValue();
            }
            right[i] = freq;
            stack.push(new Pair<>(arr[i],freq));
        }
    }

    private static void findMaximus(int []arr,int []left,int []right){
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            int freq = 1;
            //find the next greatest element and calculates its frequency of smallest element to the left
            while(!stack.isEmpty() && stack.peek().getKey() <= arr[i]){
                Pair<Integer,Integer> p = stack.pop();
                freq += p.getValue();
            }
            left[i] = freq;
            stack.push(new Pair<>(arr[i],freq));
        }

        stack.clear();

        for(int i=arr.length-1;i>=0;i--){
            int freq = 1;
            while(!stack.isEmpty() && stack.peek().getKey() < arr[i]){
                Pair<Integer,Integer> p = stack.pop();
                freq += p.getValue();
            }
            right[i] = freq;
            stack.push(new Pair<>(arr[i],freq));
        }
    }

}