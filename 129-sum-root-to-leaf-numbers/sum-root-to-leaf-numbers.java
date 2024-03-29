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
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return 0;
        helper(root,list,0);
        int sum = 0;
        System.out.print(list);
        for(int i:list) sum += i;
        return sum;
    }
    public void helper(TreeNode root,List<Integer> list,int sum){
        if(root == null){
            return;
        }

        if(isLeaf(root)){
            sum = sum * 10 + root.val;
            list.add(sum);
            return;
        }

        sum = sum * 10 + root.val;
        helper(root.left,list,sum);
        helper(root.right,list,sum);
        sum = sum % 10;
    }
    public boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}