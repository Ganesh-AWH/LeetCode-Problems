// Last updated: 9/14/2025, 9:18:05 AM
int lengthOfLastWord(char * s){
     int i=strlen(s),length=0;
     while(i>0){
         i-=1;
         if(s[i]!=' '){
             length++;
         }else if(length>0){
             return length;
         }
     }
     return length;
}