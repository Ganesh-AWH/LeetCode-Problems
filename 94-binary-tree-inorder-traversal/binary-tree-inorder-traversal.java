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
    public List<Integer> inorderTraversal(TreeNode root) {
        //iterative approach
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        List<Integer> ans = new ArrayList<>();
        while(true){
            if(temp!=null){
                stack.push(temp);
                temp = temp.left;
            }else{
                if(stack.isEmpty()) break;
                temp = stack.pop();
                ans.add(temp.val);
                temp = temp.right;
            }
        }

        return ans;
    }
}