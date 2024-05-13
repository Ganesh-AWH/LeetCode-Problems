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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        traversal(root,set);
        System.out.println(set);
        for(int i:set){
            if(set.contains(k-i) && i != k-i) return true;
        }
        return false;
    }
    public void traversal(TreeNode root,Set<Integer> set){
        if(root == null) return;

        set.add(root.val);
        traversal(root.left,set);
        traversal(root.right,set);
    }
}