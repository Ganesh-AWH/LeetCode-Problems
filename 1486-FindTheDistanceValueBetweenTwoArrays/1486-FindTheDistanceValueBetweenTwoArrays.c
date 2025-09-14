// Last updated: 9/14/2025, 9:10:16 AM
int findTheDistanceValue(int* arr1, int arr1Size, int* arr2, int arr2Size, int d){

    int temp = 0;
    int count = 0;

    for(int i=0 ; i<arr1Size ; i++){
        temp = 0;
        for(int j=0 ; j<arr2Size ; j++){
            int res = abs(arr1[i] - arr2[j]);
            if(res <= d){
                j = arr2Size;
            }else{
                temp ++ ;
            }
        }
        if(temp == arr2Size){
            count ++ ;
        }
    }

    return count ;
}