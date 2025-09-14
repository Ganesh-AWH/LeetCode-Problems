// Last updated: 9/14/2025, 9:17:21 AM
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        boolean[] used = new boolean[1 << n];
        used[0] = true;
        backtrack(n, curr, used);
        return curr;
    }
    
    private boolean backtrack(int n, List<Integer> curr, boolean[] used) {
        if (curr.size() == 1 << n) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            int nex = (1 << i) ^ curr.get(curr.size() - 1); // (1 << i) is the mask in example, nex is next valid number
            if (used[nex]) continue;
            used[nex] = true;
            curr.add(nex);
            if (backtrack(n, curr, used)) return true;
            used[nex] = false;
            curr.remove(curr.size() - 1);
        }
        return false;
    }
}