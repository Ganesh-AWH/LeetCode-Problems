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
        //brute solution
        if(root == null) return true;

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1) return false;

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        return !left || !right ? false : true;
    }
    public int findHeight(TreeNode root){
        if(root == null) return 0;
        int left = findHeight(root.left);
        int right = findHeight(root.right);

        return 1+Integer.max(left,right);
    }
}