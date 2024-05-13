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
public class BSTIterator{
    Stack<TreeNode> stack;
    boolean reverse;
    // isReverse -> true -> then class is before(); 
    // isReverse -> false -> then class is next();
    BSTIterator(TreeNode root,boolean isReverse){
        stack = new Stack<>();
        reverse = isReverse;
        pushAll(root);
    }

    public int next(){
        TreeNode current = stack.pop();
        if(reverse == false){
            pushAll(current.right);
        }else{
            pushAll(current.left);
        }

        return current.val;
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode root){
        while(root != null){
            stack.push(root);
            if(reverse == true){
                root = root.right;
            }else{
                root = root.left;
            }
        }
    } 
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        //optimal solution using bst iterator
        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);

        int i = l.next();
        int j = r.next();

        while(i<j){
            if(i+j == k) return true;

            if(i+j < k) i = l.next();
            else j = r.next();
        }

        return false;
    }
}