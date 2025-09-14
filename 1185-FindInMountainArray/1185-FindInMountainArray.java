// Last updated: 9/14/2025, 9:11:02 AM
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public static int findPeak(MountainArray mount){
        int low = 0;
        int high = mount.length()-1;
        System.out.println(high);
        while(low<high){
            int mid = low + (high - low)/2;
            if(mount.get(mid-1)>mount.get(mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public static int ascendingBS(int low,int high,int target,MountainArray mount){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(mount.get(mid) == target) return mid;
            else if(mount.get(mid) < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    public static int descendingBS(int low,int high,int target,MountainArray mount){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(mount.get(mid) == target) return mid;
            else if(mount.get(mid) > target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int minIndex = ascendingBS(0,peak,target,mountainArr);
        if(minIndex!=-1) return minIndex;
        minIndex = descendingBS(peak,mountainArr.length()-1,target,mountainArr);
        return minIndex;
    }
}