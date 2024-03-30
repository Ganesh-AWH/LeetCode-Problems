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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode,TreeNode> parents = new HashMap<>();
        //getting parents for every node
        getParents(root,parents);
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int distance = 0;
        set.add(target);
        queue.add(target);
        while(!queue.isEmpty()){
            int size = queue.size();
            if(distance == k) break;
            distance ++;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                //going left to the target
                if(node.left!=null && !set.contains(node.left)){
                    set.add(node.left);
                    queue.add(node.left);
                }
                //going right to the target
                if(node.right!=null && !set.contains(node.right)){
                    set.add(node.right);
                    queue.add(node.right);
                }
                //parent of the target
                if(parents.get(node)!=null && !set.contains(parents.get(node))){
                    set.add(parents.get(node));
                    queue.add(parents.get(node));
                }
            }
        }
        while(!queue.isEmpty()){
            ans.add(queue.poll().val);
        }
        return ans;
    }
    public void getParents(TreeNode root,Map<TreeNode,TreeNode> map){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //for root there no parent
        map.put(root,null);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    map.put(node.left,node);
                    queue.add(node.left);
                }
                if(node.right != null){
                    map.put(node.right,node);
                    queue.add(node.right);
                }
            }
        }
    }
}