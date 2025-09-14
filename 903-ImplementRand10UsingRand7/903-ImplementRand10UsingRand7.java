// Last updated: 9/14/2025, 9:11:58 AM
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int indx = 41;
        while(indx>40){
            indx = (rand7()-1)*7 + rand7();
        }
        return (indx-1)%10+1;
    }
}