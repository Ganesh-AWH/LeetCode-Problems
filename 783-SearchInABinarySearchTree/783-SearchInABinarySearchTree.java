// Last updated: 9/14/2025, 9:12:31 AM
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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        //if any node matches the val return that node
        if(root.val == val) return root;

        //go left if val is less than root
        if(root.val  > val){
            return searchBST(root.left,val);
        }

        //go right if val is greater than root
        return searchBST(root.right,val);
    }
}