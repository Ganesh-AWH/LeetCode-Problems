// Last updated: 9/14/2025, 9:18:59 AM
class Solution {
    static Map<Character,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        map.put('1',"1");
        map.put('0',"0");
        map.put('#',"#");
        map.put('*',"*");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()){
            return ans;
        }
        helper(digits.toCharArray(),0,ans,new ArrayList<>());
        return ans;
    }
    private static void helper(char []arr,int aIndex,List<String> ans,List<Character> temp){
        if(aIndex == arr.length){
            StringBuilder sb = new StringBuilder();
            for(char c:temp){
                sb.append(c);
            }
            ans.add(sb.toString());
            return;
        }

        char []letters = map.get(arr[aIndex]).toCharArray();
        for(int i=0;i<letters.length;i++){
            temp.add(letters[i]);
            helper(arr,aIndex+1,ans,temp);
            temp.remove(temp.size()-1);
        }
    }

}
