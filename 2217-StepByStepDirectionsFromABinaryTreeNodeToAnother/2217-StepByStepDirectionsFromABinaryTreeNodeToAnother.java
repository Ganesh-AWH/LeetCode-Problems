// Last updated: 9/14/2025, 9:08:43 AM
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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        //find the lowest common ancestor
        StringBuilder ans = new StringBuilder();
        TreeNode lca = lowestCommonAncestor(root, startValue, destValue);

        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        findPath(lca, startValue, pathToStart);
        findPath(lca, destValue, pathToDest);
        //add "U" for each step to go up from start to LCA
        for(int i=0; i<pathToStart.length(); i++){
            ans.append("U");
        }

        ans.append(pathToDest);
        return ans.toString();
    }
    //lowest common ancestor
    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q){
        if(root == null || root.val == p || root.val == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) return right;

        if(right == null) return left;

        else return root;
    }

    public boolean findPath(TreeNode root, int target, StringBuilder path){
        if(root == null) return false;

        if(root.val == target) return true;

        //Try left Subtree
        path.append("L");
        if(findPath(root.left, target, path)){
            return true;
        }
        //remove the last Character
        path.setLength(path.length()-1);

        //try right subtree;
        path.append("R");
        if(findPath(root.right, target, path)){
            return true;
        }
        path.setLength(path.length()-1);

        return false;
    }
}