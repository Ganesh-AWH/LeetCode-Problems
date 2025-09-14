// Last updated: 9/14/2025, 9:08:05 AM
class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int temp = money;
        temp -= prices[0];
        temp -= prices[1];

        return temp >= 0 ? temp : money;
    }
}