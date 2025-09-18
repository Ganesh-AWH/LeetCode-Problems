import java.util.*;
class TaskManager {
    Map<Integer, int[]> map; //taskId -> {userId, priority}
    // PriorityQueue<int []> pq -> i can also use this but to remove it takes o(n)
    //so i'm going with treeset
    TreeSet<int []> st; //{priority, taskId}
    public TaskManager(List<List<Integer>> tasks) {
        map = new HashMap<>();
        st =  new TreeSet<>((a, b) ->{
            //sort by priority
            if(a[0] != b[0]) return a[0] - b[0];
            //tie -> smaller taskId
            return a[1] - b[1];
        });

        for(List<Integer> task: tasks){
            this.add(task.get(0), task.get(1), task.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        st.add(new int[]{priority, taskId});
        map.put(taskId, new int[]{userId, priority});
    }
    
    public void edit(int taskId, int newPriority) {
        int []entry = map.get(taskId);
        st.remove(new int[]{entry[1], taskId}); //old {priority, taskId}
        st.add(new int[]{newPriority, taskId});
        map.put(taskId, new int[]{entry[0], newPriority});
    }
    
    public void rmv(int taskId) {
        int []entry = map.get(taskId);
        st.remove(new int[]{entry[1], taskId});
        map.remove(taskId);
    }
    
    public int execTop() {
        if(map.isEmpty()) return -1;
        int []top = st.last(); //highest priority
        int taskId = top[1];
        int userId = map.get(taskId)[0];
        st.remove(top);
        map.remove(taskId);
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