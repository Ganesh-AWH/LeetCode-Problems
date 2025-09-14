// Last updated: 9/14/2025, 9:11:29 AM
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
    int num_moves = 0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return num_moves;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        num_moves += Math.abs(left) + Math.abs(right);

        return root.val + left + right -1;
    }
}