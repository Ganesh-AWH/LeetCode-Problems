class Solution {
    public int romanToInt(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char []arr = s.toCharArray();
        int total = map.get(arr[arr.length-1]);
        int prev = total;
        for(int i=arr.length-2; i>=0; i--){
            char c = arr[i];
            int curr = map.get(c);
            if(prev > curr){
                total = total - curr;
            }else{
                total = total + curr;
            }
            prev = curr;
        }
        return total;
    }
}