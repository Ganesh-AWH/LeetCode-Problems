// Last updated: 9/14/2025, 9:19:09 AM
class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char []arr=s.toCharArray();
        int tot=map.get(arr[arr.length-1]);
        int prev=tot;
        for(int i=arr.length-2;i>=0;i--){
            int curr=map.get(arr[i]);
            if(curr>=prev){
                tot+=curr;
            }else{
                tot-=curr;
            }
            prev=curr;
        }
        return tot;
    }
}