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
        //better solution
        //solving the problem using construct binary tree from preorder and inorder 
        //in bst inorder will be ascending order
        int []inorder = Arrays.copyOf(preorder,preorder.length);
        Arrays.sort(inorder);

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return buildTree(preorder,0,preorder.length - 1,0,inorder.length - 1,map);
    }
    public TreeNode buildTree(int []preorder,int preStart,int preEnd,int inStart,int inEnd,Map<Integer,Integer> map){
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode newNode = new TreeNode(preorder[preStart]);

        int index = map.get(newNode.val);
        int noeLeft = index - inStart;

        newNode.left = buildTree(preorder,preStart+1,preStart+noeLeft,inStart,index-1,map);
        newNode.right = buildTree(preorder,preStart+noeLeft+1,preEnd,index+1,inEnd,map);

        return newNode; 
    }
}