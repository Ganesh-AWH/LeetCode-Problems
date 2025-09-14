// Last updated: 9/14/2025, 9:13:28 AM
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
    public int diameterOfBinaryTree(TreeNode root) {
        //optimal solution
        int []ans = new int[1];
        helper(root,ans);
        return ans[0];
    }
    public int helper(TreeNode root,int []ans){
        if(root == null) return 0;

        int left = helper(root.left,ans);
        int right = helper(root.right,ans);

        ans[0] = Integer.max(ans[0],left+right);

        return 1+Integer.max(left,right);
    }
}