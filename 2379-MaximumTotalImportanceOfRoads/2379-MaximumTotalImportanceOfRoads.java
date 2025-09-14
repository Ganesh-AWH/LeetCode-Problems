// Last updated: 9/14/2025, 9:08:27 AM
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int []degree = new int[n];
        for(int []road: roads){
            int u = road[0];
            int v = road[1];
            degree[u]++;
            degree[v]++; 
        }

        Integer []cities = new Integer[n];
        for(int i=0; i<n; i++){
            cities[i] = i;
        }

        //descending order of importance
        Arrays.sort(cities, (a, b) -> Integer.compare(degree[b], degree[a]));
        long totalImportance = 0;
        for(int i=0; i<n; i++){
            int city = cities[i];
            //city contribute with how many degrees
            long importance = degree[city] * (long)(n-i);
            totalImportance += importance;
        }

        return totalImportance;

    }
}