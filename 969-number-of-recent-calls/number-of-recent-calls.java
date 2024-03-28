class RecentCounter {
    Queue<Integer> request;
    public RecentCounter() {
        request = new LinkedList<>();
    }
    
    public int ping(int t) {
        request.add(t);
        
        while(request.peek() < t - 3000){
            request.poll();
        }
        return request.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */