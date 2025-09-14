// Last updated: 9/14/2025, 9:13:01 AM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node,int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root ==  null) return 0;
        int width = 0;
        //level order traversal
        //assign index for every node 
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        int first = 0;
        int last = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            //find the minimum index for that level so that we can avoid overflow error
            int minIndex = queue.peek().index;
            for(int i=0;i<size;i++){
                Pair p = queue.poll();
                TreeNode node = p.node;
                int index = p.index - minIndex;

                if(i == 0) first = index;
                if(i == size-1) last = index;
                
                //assign index for left child using (2 * i + 1);
                if(node.left != null) queue.add(new Pair(node.left,2*index+1));
                if(node.right != null) queue.add(new Pair(node.right,2*index+2));
            }
            width = Integer.max(width,last-first+1);
        }
        return width;
    }
}