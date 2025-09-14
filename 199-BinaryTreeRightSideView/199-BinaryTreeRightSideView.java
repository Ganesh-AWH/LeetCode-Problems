// Last updated: 9/14/2025, 9:15:50 AM
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
    public List<Integer> rightSideView(TreeNode root) {
        // using recursion preoder traversal with simple modification

        // for right side view
        // pre order - root left right --> root right left
        
        // for left side view
        // pre order - root left right --> root left right
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        helper(root,0,ans);
        return ans;
    }
    public void helper(TreeNode node,int lvl,List<Integer> ans){
        if(node == null) return;

        if(lvl == ans.size()){
            ans.add(node.val);
        }
        helper(node.right,lvl+1,ans);
        helper(node.left,lvl+1,ans);
    }
}