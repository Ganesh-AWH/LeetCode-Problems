// Last updated: 9/14/2025, 9:10:41 AM
import java.util.*;
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:arr){
            if(!map.containsKey(n)){
                map.put(n,1);
            }else{
                map.put(n,map.get(n)+1);
            }
        }
        Set<Integer> unique = new HashSet<>();
        Collection<Integer> list = map.values();
        for(Integer n:list){
            if(!unique.add(n)) return false;
        }

        return true;
    }
}