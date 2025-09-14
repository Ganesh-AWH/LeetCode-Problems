// Last updated: 9/14/2025, 9:17:03 AM
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root,targetSum);
    }
    public boolean helper(TreeNode root,int targetSum){
        if(root == null) return false;

        targetSum-= root.val;
        if(isLeaf(root))
            if(targetSum == 0) return true;

        return helper(root.left,targetSum) || helper(root.right,targetSum);
    }
    public boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}