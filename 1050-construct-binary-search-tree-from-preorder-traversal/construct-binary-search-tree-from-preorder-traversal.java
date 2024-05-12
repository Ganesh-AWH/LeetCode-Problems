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
    public TreeNode bstFromPreorder(int[] preorder) {
        int []index = new int[1];
        return buildTree(preorder,index,Integer.MAX_VALUE);
    }
    public TreeNode buildTree(int []preorder,int []index,int upperBound){
        if(index[0] >= preorder.length || preorder[index[0]] > upperBound) return null;

        TreeNode newNode = new TreeNode(preorder[index[0]]);
        index[0]++;
        newNode.left = buildTree(preorder,index,newNode.val);
        newNode.right = buildTree(preorder,index,upperBound);

        return newNode;
    }
}