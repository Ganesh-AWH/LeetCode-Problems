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
    private TreeNode first;
    private TreeNode middle;
    private TreeNode prev;
    private TreeNode last;
    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left); 

        if(prev!=null && (prev.val > root.val)){

            //if it is first violation
            if(first == null){
                first = prev;
                middle = root;
            }
            //else it is second violation

            else{
                last = root;
            }
        }
        prev = root;

        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        first = last = middle = null;
        inorder(root);
        //second violation does not happen then nodes are adjacent
        if(last == null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
        //second violation happens
        else{   
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
    }
}