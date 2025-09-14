// Last updated: 9/14/2025, 9:17:45 AM
class Solution {
    public String leftJustify(String[] words,int diff,int i,int j){
        int spacesOnRight = diff - (j-i-1);
        
        StringBuilder result = new StringBuilder(words[i]);
        for(int k=i+1;k<j;k++){
            result.append(" "+words[k]);
        } 
        result.append(" ".repeat(spacesOnRight));

        return result.toString();
    }
    public String middleJustify(String[] words,int diff,int i,int j){
        int spacesNeeded = j-i-1;
        int spaces = diff/spacesNeeded;
        int extraSpaces = diff % spacesNeeded;
        //store the first word initially
        StringBuilder result = new StringBuilder(words[i]);
        for(int k=i+1;k<j;k++){
            int spacesToApply = spaces + (extraSpaces-- > 0 ? 1:0);
            result.append(" ".repeat(spacesToApply)+words[k]);
        }
        return result.toString();

    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        //it stores the final result
        List<String> result = new ArrayList<>();

        int i = 0;
        int n = words.length;
        while(i<n){
            //j pointer always places after i pointer 
            int j = i+1;
            //it stores only the length of characters for that particual line
            int lineLength = words[i].length();
            while(j<n && (lineLength + words[j].length() + (j-i-1)< maxWidth)){
                lineLength += words[j].length();
                j++;
            }
            // it stores the all the spaces requires for a line
            int diff = maxWidth - lineLength;
            //no of lines for a line
            int numberOfWords = j-i;
            if(numberOfWords == 1 || j>=n){
                result.add(leftJustify(words,diff,i,j));
            }else{
                result.add(middleJustify(words,diff,i,j));
            }
            i=j;
        }
        return result;
    }
}