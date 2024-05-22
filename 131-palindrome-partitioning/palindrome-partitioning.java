class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s,0,ans,new ArrayList<>());
        return ans;
    }
    private static void helper(String s,int index,List<List<String>> ans,List<String> temp){
        if(index == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                temp.add(s.substring(index,i+1));
                helper(s,i+1,ans,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    private static boolean isPalindrome(String str,int s,int e){
        while(s<=e){
            if(str.charAt(s++) != str.charAt(e--)) return false;
        }
        return true;
    }
}