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
    public List<Integer> preorderTraversal(TreeNode root) {
        //Morris preorder traversal which gives you o(n) time complexity and o(1) space complexity
        //Morris traversal consists of threaded binary tree
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            //case -1 if left is null then print root and go for right
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            }
            //case -2 go for left and point thread 
            else{
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right != curr){
                    prev = prev.right;
                }
                //instead pointing null make thread to current and add it to the ans because it  is the root 
                if(prev.right == null){
                    prev.right = curr;
                    ans.add(curr.val);
                    curr = curr.left;
                }
                //this indicates there already a thread
                else{
                    //remove the thread
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }


        return ans;
    }
}