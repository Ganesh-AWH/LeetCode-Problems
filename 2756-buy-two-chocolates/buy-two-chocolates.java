class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int temp = money;
        temp -= prices[0];
        temp -= prices[1];

        return temp >= 0 ? temp : money;
    }
}