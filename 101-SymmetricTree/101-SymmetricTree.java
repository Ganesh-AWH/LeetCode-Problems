// Last updated: 9/14/2025, 9:17:13 AM
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return helper(root,root);
    }
    public boolean helper(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null) return true;

        if(root1 == null || root2 == null || root1.val != root2.val) return false;

        boolean flag1 = helper(root1.left,root2.right);
        boolean flag2 = helper(root1.right,root2.left);

        return flag1 && flag2;
    }
}