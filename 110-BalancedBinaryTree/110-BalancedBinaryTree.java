// Last updated: 9/14/2025, 9:17:06 AM
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
    public boolean isBalanced(TreeNode root) {
        //optimal solution
        return helper(root) == -1 ? false:true;
    }
    //using height of the tree concept
    public int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);
        //two condition is important to check the condition
        if(left == -1 || right == -1 ) return -1;
        if(Math.abs(left-right) > 1) return -1;
        return 1+Integer.max(left,right);
    }
}