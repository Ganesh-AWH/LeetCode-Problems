// Last updated: 9/14/2025, 9:17:08 AM
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //hash the inorder elements with index
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }    

        TreeNode root = buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1,map);

        return root;
    }
    public TreeNode buildTree(int []preorder,int []inorder,int preStart,int preEnd,int inStart,int inEnd,Map<Integer,Integer> map){
        //base condition
        if(preStart > preEnd || inStart > inEnd) return null;

        //because preorder is root left and right
        TreeNode root = new TreeNode(preorder[preStart]);

        //find the index of the root in inorder 
        int index = map.get(root.val);
        //find the number of elements on the left
        int noeLeft = index - inStart;

        root.left = buildTree(preorder,inorder,preStart+1,preStart+noeLeft,inStart,index-1,map);

        root.right = buildTree(preorder,inorder,preStart+noeLeft+1,preEnd,index+1,inEnd,map);

        return root; 
    }
}