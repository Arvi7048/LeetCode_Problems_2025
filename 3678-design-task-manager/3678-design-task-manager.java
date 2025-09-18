import java.util.*;

class TaskManager {

    // TreeSet to keep tasks sorted by priority DESC, then taskId DESC
    private TreeSet<Task> taskSet;
    // Map to quickly access tasks by taskId
    private HashMap<Integer, Task> taskMap;

    // Inner Task class
    private static class Task implements Comparable<Task> {
        int userId;
        int taskId;
        int priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        @Override
        public int compareTo(Task other) {
            if (this.priority != other.priority) {
                return Integer.compare(other.priority, this.priority); // higher priority first
            }
            return Integer.compare(other.taskId, this.taskId); // higher taskId first
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Task)) return false;
            Task t = (Task) o;
            return taskId == t.taskId;
        }

        @Override
        public int hashCode() {
            return taskId;
        }
    }

    // Constructor: initialize with a list of tasks
    public TaskManager(List<List<Integer>> tasks) {
        taskSet = new TreeSet<>();
        taskMap = new HashMap<>();
        for (List<Integer> t : tasks) {
            int userId = t.get(0);
            int taskId = t.get(1);
            int priority = t.get(2);
            Task task = new Task(userId, taskId, priority);
            taskSet.add(task);
            taskMap.put(taskId, task);
        }
    }

    // Add a new task
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskSet.add(task);
        taskMap.put(taskId, task);
    }

    // Edit the priority of an existing task
    public void edit(int taskId, int newPriority) {
        Task task = taskMap.get(taskId);
        if (task != null) {
            taskSet.remove(task);       // remove old task
            task.priority = newPriority; // update priority
            taskSet.add(task);          // reinsert
        }
    }

    // Remove a task by taskId
    public void rmv(int taskId) {
        Task task = taskMap.get(taskId);
        if (task != null) {
            taskSet.remove(task);
            taskMap.remove(taskId);
        }
    }

    // Execute the top task: highest priority, highest taskId tiebreaker
    public int execTop() {
        if (taskSet.isEmpty()) return -1;
        Task top = taskSet.first();
        taskSet.remove(top);
        taskMap.remove(top.taskId);
        return top.userId;
    }
}
