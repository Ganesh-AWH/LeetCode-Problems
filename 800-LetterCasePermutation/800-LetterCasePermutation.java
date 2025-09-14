// Last updated: 9/14/2025, 9:12:24 AM
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        helper(s.toCharArray(),ans,0,new ArrayList<>());
        return ans;
    }
    private static void helper(char []arr,List<String> ans,int index,List<Character> temp){
        if(index >= arr.length){
            StringBuilder sb = new StringBuilder();
            for(char c:temp) sb.append(c);
            ans.add(sb.toString());
            return;
        }
        char c = arr[index];
        if (Character.isLetter(c)) {
            if (Character.isUpperCase(c)) {
                temp.add(c);
                helper(arr,ans,index+1,temp);
                temp.remove(temp.size()-1);
                c=Character.toLowerCase(c);
                temp.add(c);
                helper(arr,ans,index+1,temp);
                temp.remove(temp.size()-1);
            }else{
                c = Character.toUpperCase(c);
                temp.add(c);
                helper(arr,ans,index+1,temp);
                temp.remove(temp.size()-1);
                c=Character.toLowerCase(c);
                temp.add(c);
                helper(arr,ans,index+1,temp);
                temp.remove(temp.size()-1);
            }
            
        }else{
            temp.add(c);
            helper(arr,ans,index+1,temp);
            temp.remove(temp.size()-1);
        }
    }
}