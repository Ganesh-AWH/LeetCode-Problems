// Last updated: 9/14/2025, 9:17:07 AM
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //if you can solve Construct Binary Tree from Inorder and Preorder Traversal then it will be easy
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = build(postorder,inorder,0,postorder.length-1,0,inorder.length-1,map);

        return root;
    }
    public TreeNode build(int []postorder,int []inorder,int poStart,int poEnd,int inStart,int inEnd,Map<Integer,Integer> map){
        if(poStart > poEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[poEnd]);

        int index = map.get(root.val);
        int noeLeft = index - inStart;

        root.left = build(postorder,inorder,poStart,poStart+noeLeft-1, inStart,index-1,map);
        root.right = build(postorder,inorder,poStart+noeLeft,poEnd-1,index+1,inEnd,map);

        return root;
    }
}