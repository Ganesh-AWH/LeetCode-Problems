class Node{
    Node []links;
    boolean flag;
    Node(){
        links = new Node[26];
        flag = false;
    }
    public boolean containsKey(char c){
        return links[c - 'a'] != null;
    }
    public Node get(char c){
        return links[c - 'a'];
    }

    public void put(char c, Node node){
        links[c - 'a'] = node;
    }

    public void setEnd(){
        flag = true;
    }

    public boolean isEnd(){
        return flag;
    }
}
class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            //if the character does not contains the add it 
            if(!node.containsKey(c)){
                node.put(c, new Node());
            }
            node = node.get(c);
        }
        //if the word end mark it has true
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(!node.containsKey(c)) return false;
            node = node.get(c); 
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!node.containsKey(c)) return false;
            node = node.get(c);
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */