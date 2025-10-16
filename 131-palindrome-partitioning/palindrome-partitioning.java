class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        
        findPartition(0, s, new ArrayList<>(), ans);
        return ans;
    }
    public static void findPartition(int index, String str, List<String> temp, List<List<String>> ans){
        if(index == str.length()){
            ans.add(new ArrayList<>(temp));
        }

        for(int i=index; i<str.length(); i++){
            String substr = str.substring(index, i+1);
            if(isPalindrome(substr)){
                temp.add(substr);
                findPartition(i+1, str, temp, ans);
                temp.remove(temp.size()-1);
            }
        }

    }
    public static boolean isPalindrome(String str){
        int i = 0;
        int j = str.length() - 1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++; 
            j--;
        }
        return true;
    }
}