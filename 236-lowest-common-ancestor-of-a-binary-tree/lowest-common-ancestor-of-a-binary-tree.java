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
        //naive approach
        /*
            get the paths for both the given nodes as list
            iterate both the list simultaneously if list1 != list2 then its previous will be ans(lca)
         */
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
    public boolean getPath(TreeNode node,TreeNode p,List<TreeNode> path){
        if(node == null) return false;

        path.add(node);
        if(node == p) return true;

        if(getPath(node.left,p,path) || getPath(node.right,p,path)) return true;

        path.remove(path.size()-1);

        return false;
    }
}