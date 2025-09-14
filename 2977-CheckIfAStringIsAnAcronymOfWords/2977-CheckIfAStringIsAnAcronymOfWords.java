// Last updated: 9/14/2025, 9:07:54 AM
class Solution {
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder sb = new StringBuilder();

        //getting all first letters from the list of String
        for(String x: words){
            sb.append(x.charAt(0));
        }
        System.out.print(sb);
        return sb.toString().equals(s);
    }
}

//TC : O(N)
//SC : O(N)