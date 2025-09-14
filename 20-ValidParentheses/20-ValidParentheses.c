// Last updated: 9/14/2025, 9:19:03 AM
bool isValid(char * s){
    if(strlen(s)%2==1){
        return false;
    }
    char stack[10000];
    int top=-1;
    for(int i=0;s[i]!='\0';i++){
            switch(s[i]){
                case '(':
                case '{':
                case '[':
                     stack[++top]=s[i];
                     break;
                case ')':{
                      if(top<0 || stack[top]!='('){
                          return false;
                      }else{
                          top--;
                      }
                      break;
                    }
                case ']':{
                      if(top<0 || stack[top]!='['){
                          return false;
                      }else{
                          top--;
                      }
                      break;
                    }
                case '}':{
                      if(top<0 || stack[top]!='{'){
                          return false;
                      }else{
                          top--;
                      }
                      break;
                    }
                default:
                      return false;
            }
    }
      return top==-1;
}