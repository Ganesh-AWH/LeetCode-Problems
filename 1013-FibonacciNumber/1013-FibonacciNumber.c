// Last updated: 9/14/2025, 9:11:35 AM
int fib(int n){
    if(n<=1){
        return n;
    }
    int a=0;
    int b=1;
    int r=0;
    for(int i=2;i<=n;i++){
        r = a + b;
        a = b;
        b = r; 
    }
    return r;
}