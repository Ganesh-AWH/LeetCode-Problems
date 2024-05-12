/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        //optimal solution
        // check whether root node is smaller than both p and q if it is the go for left
        // if both nodes greater then go for right
        //else there is separation then root node is answer

        TreeNode temp = root;
        while(temp!=null){
            if(temp.val > p.val && temp.val > q.val){
                temp = temp.left;
            }
            else if(temp.val < p.val && temp.val < q.val){
                temp = temp.right;
            }else{
                return temp;
            }
        }
        return null;
    }
}