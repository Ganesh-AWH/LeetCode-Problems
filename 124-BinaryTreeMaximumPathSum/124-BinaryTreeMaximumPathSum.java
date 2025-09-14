// Last updated: 9/14/2025, 9:16:50 AM
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
    public int maxPathSum(TreeNode root) {
        int []ans = new int[]{Integer.MIN_VALUE};
        helper(root,ans);
        return ans[0];
    }
    //use height of the tree concept
    public int helper(TreeNode root,int []ans){
        if(root == null) return 0;
        //0,helper() is used to remove negative sum path if sum is negative then removing that path       
        int left = Integer.max(0,helper(root.left,ans));
        int right = Integer.max(0,helper(root.right,ans));
        ans[0] = Integer.max(ans[0],left+right+root.val);


        //deciding whether to take left path or right path
        return root.val+Integer.max(left,right);
    }
}