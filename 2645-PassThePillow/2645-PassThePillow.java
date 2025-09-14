// Last updated: 9/14/2025, 9:08:12 AM
class Solution {
    public int passThePillow(int n, int time) {
        //true means forward and false mean backward
        boolean direction = true;
        int index = 1;
        while(time-->0){
            if(direction){
                index++;
                if(index == n){
                    direction = false;
                }
            }else{
                index--;
                if(index == 1){
                    direction = true;
                }
            }
        }

        return index;
    }
}