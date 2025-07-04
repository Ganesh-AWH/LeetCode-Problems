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
    public boolean evaluateTree(TreeNode root) {
        //post order traversal 
        if(isLeaf(root)){
            return root.val == 1;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if(root.val == 2){
            return left | right;
        }else{
            return left & right;
        }
    }
    public boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}