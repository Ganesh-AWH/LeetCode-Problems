// Last updated: 9/14/2025, 9:12:48 AM
class Disjoint{
    int []size;
    int []parent;
    Disjoint(int n){
        size = new int[n+1];
        parent = new int[n+1];
        for(int i=0;i<=n;i++){
            size[i] = 1;
            parent[i] = i;
        }
    }
    public int findParent(int node){
        if(node == parent[node]){
            return node;
        }
        parent[node] = findParent(parent[node]);
        return parent[node];
    }
    public void unionBySize(int u,int v){
        //ultimate parent of u
        int pu = findParent(u);
        //ultimate parent of v
        int pv = findParent(v);

        if(pu == pv) return;

        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        //if the size is equal then we can do anything 
        else{
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        //the mail is the mapping to corresponding names
        //here the names are considered to be index 0,1,2,..
        Map<String,Integer> map = new HashMap<>();
        int n = accounts.size();
        Disjoint ds = new Disjoint(n);
        for(int i=0;i<n;i++){
            //zero will contains the name
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail,i);
                }else{
                    //the mail is already present
                    int u = i;
                    int v = map.get(mail);
                    ds.unionBySize(u,v);
                }
            }
        }

        //merging the mail 
        List<List<String>> mergeMail = new ArrayList<>();
        for(int i=0;i<n;i++){
            mergeMail.add(new ArrayList<>());
        }

        for(Map.Entry<String,Integer> it:map.entrySet()){
            String mail = it.getKey();
            int node = it.getValue();
            //find the ultimate parent of the node
            int parent = ds.findParent(node);
            mergeMail.get(parent).add(mail);
        }

        //add the names and sort the string
        for(int i=0;i<n;i++){
            //the nodes which are empty
            if(mergeMail.get(i).size() == 0) continue;
            //first the sort the string
            Collections.sort(mergeMail.get(i));
            List<String> temp = new ArrayList<>();
            //add the name the list first
            temp.add(accounts.get(i).get(0));
            //add the sorted string next
            for(String s:mergeMail.get(i)){
                temp.add(s);
            }
            ans.add(temp);
        }

        return ans;
    }
}