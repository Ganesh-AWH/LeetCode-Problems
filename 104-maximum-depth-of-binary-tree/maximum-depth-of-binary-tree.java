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
    public int maxDepth(TreeNode root) {
        //Height of the tree using recursion - better approach
        return helper(root);
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        
        //find height of left
        int left = helper(root.left);
        //find height of right
        int right = helper(root.right);
        //curr node plus max(left height,rigth height)
        return 1+Integer.max(left,right);
    }
}