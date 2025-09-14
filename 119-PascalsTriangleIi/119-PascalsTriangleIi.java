// Last updated: 9/14/2025, 9:16:56 AM
class Solution {
    public List<Integer> getRow(int rowIndex) {
        // List<Integer> res = new ArrayList<Integer>();
        List<Integer> prev = new ArrayList<>();
        prev.add(1);

        if(rowIndex == 0) {
            return prev;
        }

        List<Integer> curr = new ArrayList<>();
        for(int i=1;i<=rowIndex;i++){
            curr = new ArrayList<>();
            curr.add(1);
            for(int j=0;j<prev.size()-1;j++){
                curr.add(prev.get(j)+prev.get(j+1));
            }
            curr.add(1);
            prev = curr;
        }
        return curr;
    }
}