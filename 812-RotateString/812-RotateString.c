// Last updated: 9/14/2025, 9:12:22 AM
bool rotateString(char * s, char * goal){
    if(strlen(s)!=strlen(goal)){return false;}
      char temp[strlen(s)*2+1];
      strcpy(temp,s);
      strcat(temp,s);
      if(strstr(temp,goal)){
          return true;
      }
      return false;
}