// Last updated: 9/14/2025, 9:07:21 AM
class Solution {
    public List<String> validStrings(int n) {
        List<String> ans = print(n);    
        return ans;
    }
    static void All_Binary_Strings(String str, int num, List<String> ans){
        int len = str.length();
        if (len == num) {
            ans.add(str);
            return;
        }
        else if (str.charAt(len - 1) == '0')
            All_Binary_Strings(str + '1', num, ans);
        else {
            All_Binary_Strings(str + '1', num, ans);
            All_Binary_Strings(str + '0', num, ans);
        }
    }
 
    static List<String> print(int num)
    {
        List<String> ans = new ArrayList<>();
        String word = "";
        word += '0';
        All_Binary_Strings(word, num, ans);
        word = "1";
        All_Binary_Strings(word, num, ans);

        return ans;
    }
}