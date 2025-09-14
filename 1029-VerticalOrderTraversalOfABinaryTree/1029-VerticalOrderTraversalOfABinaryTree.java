// Last updated: 9/14/2025, 9:11:28 AM
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
    class Tuple{
        TreeNode node;
        int ver;
        int hor;
        Tuple(TreeNode node,int ver,int hor){
            this.node = node;
            this.ver = ver;
            this.hor = hor;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //inorder traversal
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Tuple tup = new Tuple(root,0,0);
        helper(tup,map);

        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> verticals : map.values()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> nodes : verticals.values()){
                while(!nodes.isEmpty()){
                    list.add(nodes.poll());
                }
            }
            ans.add(list);
        }


        return ans;
    }
    public void helper(Tuple tup,TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map){
        if(tup.node == null) return;
        
        TreeNode node = tup.node;
        int ver = tup.ver;
        int hor = tup.hor;
        if(!map.containsKey(ver)) map.put(ver,new TreeMap<>());
        if(!map.get(ver).containsKey(hor)) map.get(ver).put(hor,new PriorityQueue<>());
        map.get(ver).get(hor).add(node.val);

        tup.node = node.left;
        tup.ver = ver - 1;
        tup.hor = hor + 1;
        helper(tup,map);
        
        tup.node = node.right;
        tup.ver = ver + 1;
        tup.hor = hor + 1;        
        helper(tup,map);
    }
}