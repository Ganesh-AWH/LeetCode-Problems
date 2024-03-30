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
    //using complete binary tree property we can reduce the time complexity
    //for a node left height and right height is equal then use this formula 2^h - 1;
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);

        if(leftHeight == rightHeight){
            //it is 2 power using bit manipulation - 
            return ((2<<(leftHeight))-1);
        }
        else 
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public int findLeftHeight(TreeNode node){
        int height = 0;
        while(node.left!=null){
            height++;
            node = node.left;
        }
        return height;
    }
    public int findRightHeight(TreeNode node){
        int height = 0;
        while(node.right!=null){
            height++;
            node = node.right;
        }
        return height;
    }
}