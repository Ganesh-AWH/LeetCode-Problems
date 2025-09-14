// Last updated: 9/14/2025, 9:18:44 AM
int strStr(char * str, char * key){
  int l1=strlen(str);
        int l2=strlen(key);
        int i=0,j=0,w=0,k=0,g=0;
        while(1){
            if(str[w+j]==key[j]){
                 if(k==0){
                     g=w;
                     k=1;
                 }
                 j++;
            }else{
                w++;
                j=0;
                k=0;
            }
            if(j==l2){
                return g;
            }
            if(w==l1){
                break;
            }
        }
        return -1;
}