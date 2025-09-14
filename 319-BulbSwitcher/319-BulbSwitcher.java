// Last updated: 9/14/2025, 9:14:45 AM
class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
//Best approch
/*
* find factors for every i if count is odd then bulb is on at last
 <OR>
* The number which factors count is equal to odd is perfect sqaure
 <OR>

* Then count of perfect sqaures can be found using root(n)
*/