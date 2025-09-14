// Last updated: 9/14/2025, 9:10:57 AM
class Solution {
    public int findSpecialInteger(int[] arr) {
        int a = arr.length/4;
        int count = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1] == arr[i]){
                count++;
                if(count > a) return arr[i];
            }else{
                count = 1;
            }
        }
        return 1;
        
    }
}