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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //use iteration to solve this problem
        if(root == null) return new TreeNode(val);

        //make copy of root 
        TreeNode temp = root;
        while(temp!=null){
            //curr value is greater than new node value then go left
            if(temp.val > val){
                //move left if left node exist
                if(temp.left != null) temp = temp.left;
                else{
                    temp.left = new TreeNode(val);
                    break;
                }
            }else{
                //move right if right node exist
                if(temp.right != null) temp = temp.right;
                else{
                    temp.right = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }
}