package co.edu.udea.calidadsoftware.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToDoManagement {
    private static final Logger logger = LoggerFactory.getLogger(ToDoManagement.class);

    private List<Task> toDoList;

    public ToDoManagement() {
        this.toDoList = new ArrayList<>();
    }

    public void addTask(String desc) {
        String taskId = System.currentTimeMillis() + "";
        Task taskToAdd = new Task(taskId, desc);
        this.toDoList.add(taskToAdd);
    }

    public void listTasks() {
        if (this.toDoList == null || this.toDoList.isEmpty()) {
            logger.warn("There are no tasks to show");
            return;
        }
        logger.info("");
        this.toDoList.forEach(task -> {
            String taskStatus = task.getCompletedAt() != null ? "Completed" : "Pending";
            logger.info("Id: " + task.getId() + ", Description: " + task.getDesc() + ", Status: " + taskStatus);
        });
    }

    public void deleteTask(String id) {
        this.toDoList = this.toDoList.stream().filter(task -> !task.getId().equals(id)).collect(Collectors.toList());
    }

    public boolean existsById(String id) {
        return this.toDoList.stream().anyMatch(task -> task.getId().equals(id));
    }

    public void completeTask(String id) {
        this.toDoList = this.toDoList.stream().peek(task -> {
            if (task.getId().equals(id)) {
                task.setCompletedAt(java.time.LocalDateTime.now());
            }
        }).collect(Collectors.toList());
    }

    public void showCompletedTasks() {
        List<Task> completedTasks = this.toDoList.stream().filter(task -> task.getCompletedAt() != null).collect(Collectors.toList());
        if (completedTasks.isEmpty()) {
            logger.warn("There are no completed tasks");
            return;
        }
        logger.info("");
        completedTasks.forEach(task -> {
            logger.info("Id: " + task.getId() + ", Description: " + task.getDesc() + ", Completed at: " + task.getCompletedAt());
        });
    }

    public void showPendingTasks() {
        List<Task> pendingTasks = this.toDoList.stream().filter(task -> task.getCompletedAt() == null).collect(Collectors.toList());
        if (pendingTasks.isEmpty()) {
            logger.warn("There are no pending tasks");
            return;
        }
        System.out.println();
        pendingTasks.forEach(task -> {
            logger.info("Id: " + task.getId() + ", Description: " + task.getDesc());
        });
    }
}
