// Last updated: 9/14/2025, 9:07:25 AM
class Solution {
    public int numberOfChild(int n, int k) {
        int position = 0;
        boolean goingRight = true;

        for (int i = 0; i < k; i++) {
            if (goingRight) {
                if (position == n - 1) {
                    goingRight = false;
                    position--;
                } else {
                    position++;
                }
            } else {
                if (position == 0) {
                    goingRight = true;
                    position++;
                } else {
                    position--;
                }
            }
        }

        return position;
    }
}