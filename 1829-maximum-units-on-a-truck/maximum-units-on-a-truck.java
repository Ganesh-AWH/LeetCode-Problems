class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //sort based on units
        Comparator<int []> com = new Comparator<>(){
            public  int compare(int []a,int []b){
                return b[1] - a[1];
            }
        };
        Arrays.sort(boxTypes,com);
        int load = 0;
        int units = 0;
        for(int i=0;i<boxTypes.length;i++){
            if(load+boxTypes[i][0] <= truckSize){
                units += (boxTypes[i][1] * boxTypes[i][0]);
                load += boxTypes[i][0];
            }else{
                int rem = truckSize - load;
                units += rem * boxTypes[i][1];
                break;
            }
        }
        return units;
    }
}