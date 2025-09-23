class Solution {
    public String minRemoveToMakeValid(String s) {
        int start = 0;
        int end = s.length()-1;

        char []arr = s.toCharArray();

        int openParanthesis = 0;
        // First pass: mark excess closing parentheses with '*'
        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            if(c == '('){
                openParanthesis++;
            }

            else if(c == ')'){
                if(openParanthesis == 0){
                    arr[i] = '*';
                }else{
                    openParanthesis--;
                }
            }
        }

        //second pass: mark excess open parantheses with '*' from right to left
        for(int i=arr.length-1; i>=0; i--){
            char c = arr[i];
            if(openParanthesis > 0 && c == '('){
                arr[i] = '*';
                openParanthesis--;
            }
        }
        StringBuilder sb = new StringBuilder();
        //Filter out marked characters and store the result in the string builder
        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            if(c != '*'){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}