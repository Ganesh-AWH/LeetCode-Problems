// Last updated: 9/14/2025, 9:14:26 AM
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        //use priority queue that use min heap for sum of pairs 
        PriorityQueue<int []> queue = new PriorityQueue<>((a,b) -> (a[0]+a[1]) - (b[0] + b[1]));

        for(int i=0;i<nums1.length;i++){
            //for eg 1,7,11 & 2,4,6 -> (1,2)(7,2)(11,2)
                                //nums1  nums2    index of nums2
            queue.add(new int[]{nums1[i],nums2[0],0});
        }

        while(k-->0){
            int []curr = queue.poll();
            List<Integer> temp = new ArrayList<>();
            //the queue will sort based on sum
            temp.add(curr[0]);
            temp.add(curr[1]);
            ans.add(new ArrayList<>(temp));
            //taking the previous index
            int index = curr[2]+1;
            if(index < nums2.length){
                queue.add(new int[]{curr[0],nums2[index],index});
            }
        }
        return ans;
    }
}