// Last updated: 9/14/2025, 9:10:19 AM
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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        helper(root,root,target,false);
        if(isLeaf(root) && root.val == target) root = null;

        return root;
    }
    public void helper(TreeNode root,TreeNode parent,int target,boolean isLeftChild){
        //boundary condition
        if(root == null) return;

        //boolean is to check whether the node is leftchild or rightchild
        helper(root.left,root,target,true);
        helper(root.right,root,target,false);

        if(isLeaf(root) && root.val == target){
            //delete the node
            if(isLeftChild){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
    }
    public boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}