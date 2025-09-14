// Last updated: 9/14/2025, 9:12:11 AM
int peakIndexInMountainArray(int* arr, int arrSize){
            int start = 0 ;
            int end = arrSize - 1;
            int mid = 0 ;
            while(start < end ){
                mid = start + (end - start)/2;
                if(arr[mid] > arr[mid+1] ){
                    end = mid ;
                }else{
                    start = mid + 1;
                }
            }
            return start;
}