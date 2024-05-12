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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        getPath(root,p,path1);
        getPath(root,q,path2);

        TreeNode ans = null;
        int i=0;
        while(i<path1.size() && i<path2.size()){
            if(path1.get(i) != path2.get(i)){
                break;
            }
            ans = path1.get(i);
            i++;
        }
        return ans;
    }
    public void getPath(TreeNode root,TreeNode dest,List<TreeNode> paths){
        if(root == null) return;

        if(root.val == dest.val){
            paths.add(root);
            return;
        }

        if(root.val > dest.val){
            paths.add(root);
            getPath(root.left,dest,paths);
        }else{
            paths.add(root);
            getPath(root.right,dest,paths);
        }
    }
}