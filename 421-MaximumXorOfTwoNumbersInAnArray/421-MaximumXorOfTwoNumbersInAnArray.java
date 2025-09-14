// Last updated: 9/14/2025, 9:14:08 AM
class Node{
    Node []links = new Node[2];
    public boolean containsKey(int bit){
        return links[bit] != null;
    }

    public void put(int bit, Node node){
        links[bit] = node;
    }

    public Node get(int bit){
        return links[bit];
    }
}

class Trie{
    Node root;
    Trie(){
        root = new Node();
    }

    public void insert(int num){
        Node node = root;
        for(int i=31; i>=0; i--){
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num){
        Node node = root;
        int maxAns = 0;
        for(int i=31; i>=0; i--){
            int bit = (num >> i) & 1;
            if(node.containsKey(1 - bit)){
                maxAns = (1 << i) | maxAns;
                node = node.get((1-bit));
            }else{
                node = node.get(bit);
            }
        }

        return maxAns;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int i:nums){
            trie.insert(i);
        }
        int maxAns = Integer.MIN_VALUE;
        for(int i:nums){
            maxAns = Integer.max(maxAns, trie.getMax(i));
        }

        return maxAns;
    }
}