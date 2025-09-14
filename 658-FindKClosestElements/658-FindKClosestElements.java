// Last updated: 9/14/2025, 9:13:02 AM
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> li = new ArrayList<>();
        for(int i:arr){
            li.add(i);
        }
        Collections.sort(li, (num1, num2) -> Math.abs(num1 - x) - Math.abs(num2 - x));
        li = li.subList(0,k);
        Collections.sort(li);
        return li;
    }
}