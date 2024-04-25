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
    public int kthSmallest(TreeNode root, int k) {
        //using morris algorithm for inorder traversal
        TreeNode curr = root;
        int count =  0;
        int ans = -1;
        while(curr!=null){
            //case -1 if left is null then print root and go for right
            if(curr.left == null){
                count++;
                if(count == k) return curr.val;
                curr = curr.right;
            }
            //case -2 go for left and point thread 
            else{
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right != curr){
                    prev = prev.right;
                }
                //instead pointing null make thread to current
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                //this indicates there already a thread
                else{
                    //remove the thread
                    prev.right = null;
                    count++;
                    if(count == k) return curr.val;
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}