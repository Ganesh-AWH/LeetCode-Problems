// Last updated: 9/14/2025, 9:09:56 AM
import java.util.*;
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        int x = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        List<Integer> v = new ArrayList<>(map.values());
        Collections.sort(v);

        int removed = 0;
        for(int i=0;i<v.size();i++){
            removed += v.get(i);
            if(removed > k){
                return v.size() - i;
            }
        }
        return 0;
    }
}