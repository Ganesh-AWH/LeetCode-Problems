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

        //for every node find parent node
        Map<TreeNode,TreeNode> parents = new HashMap<>();
        findParents(root,parents);
        // System.out.println(parents.size());
        //finding the distance
        int distance = 0;
        //making visted nodes
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        set.add(target);
        while(!queue.isEmpty()){
            int size = queue.size();
            if(distance == k) break;
            distance++;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null && !set.contains(node.left)){
                    queue.add(node.left);
                    set.add(node.left);
                }
                if(node.right!=null && !set.contains(node.right)){
                    queue.add(node.right);
                    set.add(node.right);
                }
                if(parents.get(node)!=null && !set.contains(parents.get(node))){
                    queue.add(parents.get(node));
                    set.add(parents.get(node));
                }
            }
        }
        while(!queue.isEmpty()){
            ans.add(queue.poll().val);
        }
        return ans;
    }
    public void findParents(TreeNode root,Map<TreeNode,TreeNode> map){
        //use level order traversal for finding parents
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root,null);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    map.put(node.left,node);
                    queue.add(node.left);
                }
                if(node.right!=null){
                    map.put(node.right,node);
                    queue.add(node.right);
                }
            }
        }


    }
}