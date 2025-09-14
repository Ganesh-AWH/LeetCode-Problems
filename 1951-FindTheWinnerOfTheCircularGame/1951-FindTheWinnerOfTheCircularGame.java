// Last updated: 9/14/2025, 9:09:12 AM
class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> friends = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }
        
        int current_position = 0;
        
        while (n > 1) {
            current_position = (current_position + (k - 1)) % n;
            friends.remove(current_position);
            n--;
        }
        
        return friends.get(0);
    }
}