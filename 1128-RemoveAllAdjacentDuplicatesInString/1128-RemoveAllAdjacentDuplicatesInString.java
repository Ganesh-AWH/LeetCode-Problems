// Last updated: 9/14/2025, 9:11:15 AM
class Solution {
    public String removeDuplicates(String s) {
          char []stack = new char[s.length()];
          int top=-1;
          for(char c:s.toCharArray()){
              if(top==-1){
                  stack[++top]=c;
              }else if(stack[top]==c){
                  top--;
              }else{
                  stack[++top]=c;
              }
          }
          return new String(stack,0,top+1);
    }
}