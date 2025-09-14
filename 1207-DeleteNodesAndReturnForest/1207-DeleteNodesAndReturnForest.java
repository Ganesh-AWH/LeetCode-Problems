// Last updated: 9/14/2025, 9:10:59 AM
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        //post order traversal
        //it is the traversal which computes the children first before the node
        //LRP -> left right parent

        Set<Integer> toDelete = new HashSet<>();
        for(int i: to_delete) toDelete.add(i);

        List<TreeNode> forest = new ArrayList<>();

        root = postOrder(root, toDelete, forest);

        if(root != null) forest.add(root);

        return forest;
    }
    public TreeNode postOrder(TreeNode node, Set<Integer> toDelete, List<TreeNode> forest){
        if(node == null) return null;

        node.left = postOrder(node.left, toDelete, forest);
        node.right = postOrder(node.right, toDelete, forest);

        //processing the parent 
        //if the node value is to delete
        if(toDelete.contains(node.val)){
            //if left contains value then add it to the forest
            if(node.left != null){
                forest.add(node.left);
            }
            if(node.right != null){
                forest.add(node.right);
            }

            //marking the current node as null
            return null;
        }

        return node;
        
    }
}