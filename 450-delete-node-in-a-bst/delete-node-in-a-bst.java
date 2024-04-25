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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val == key) return helper(root);

        TreeNode temp = root;
        //searching the node
        while(temp != null){
            //go for left to search node
            if(temp.val > key){
                if(temp.left !=null && temp.left.val == key){
                    temp.left = helper(temp.left);
                    break;
                }else{
                    temp = temp.left;
                }
            }
            //go for right to search node
            else{
                if(temp.right != null && temp.right.val == key){
                    temp.right = helper(temp.right);
                    break;
                }else{
                    temp = temp.right;
                }
            }
        }

        return root;
    }
    public TreeNode helper(TreeNode root){
        //if right has null return left
        if(root.right == null) return root.left;
        //if left has null return right
        if(root.left == null) return root.right;

        //mark down the right child
        TreeNode rightChild = root.right;
        //find the left child's rightmost child
        TreeNode rightMostChild = findRightMostChild(root.left);

        rightMostChild.right = rightChild;

        return root.left;
    }
    public TreeNode findRightMostChild(TreeNode root){
        if(root.right == null) return root;

        return findRightMostChild(root.right);
    }
}