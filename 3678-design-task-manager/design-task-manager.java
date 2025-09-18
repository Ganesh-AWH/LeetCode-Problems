class TaskManager {
    Map<Integer, int []> map; //taskId -> {userId, priority}
    TreeSet<int []> tSet; //{priority, taskId}
    public TaskManager(List<List<Integer>> tasks) {
        map = new HashMap<>();
        tSet = new TreeSet<>((a,b) ->{
            if(a[0] != b[0]) return a[0] - b[0];
            
            else return a[1] - b[1];
        });

        for(List<Integer> task: tasks){
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            this.add(userId, taskId, priority);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        map.put(taskId, new int[]{userId, priority});
        tSet.add(new int[]{priority, taskId});
    }
    
    public void edit(int taskId, int newPriority) {
        int []entry = map.get(taskId); 
        int userId = entry[0];
        int priority = entry[1];
        tSet.remove(new int[]{priority, taskId});
        tSet.add(new int[]{newPriority, taskId});
        map.put(taskId, new int[]{userId, newPriority}); 
    }
    
    public void rmv(int taskId) {
        int []entry = map.get(taskId); 
        int userId = entry[0];
        int priority = entry[1];
        tSet.remove(new int[]{priority, taskId});
        map.remove(taskId);
    }

    public int execTop() {
        if(map.isEmpty()) return -1;

        int []top = tSet.last(); // taking the highest priority 
        int priority = top[0];
        int taskId = top[1];
        int userId = map.get(taskId)[0];
        this.rmv(taskId);
        return userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */