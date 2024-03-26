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
        int hor;
        int ver;
        Tuple(TreeNode node,int ver,int hor){
            this.node = node;
            this.hor = hor;
            this.ver = ver;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        //Tree map
        //vertical-lvl //horizontal level //elements is ascending order
        TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root,0,0));

        //using level order traversal
        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int v = tuple.ver;
            int h = tuple.hor;

            if(!map.containsKey(v)){
                map.put(v,new TreeMap<>());
            }
            if(!map.get(v).containsKey(h)){
                map.get(v).put(h,new PriorityQueue<>());
            }
            map.get(v).get(h).add(node.val);

            if(node.left != null){
                queue.add(new Tuple(node.left,v-1,h+1));
            }
            if(node.right != null){
                queue.add(new Tuple(node.right,v+1,h+1));
            }

        }
        
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
}