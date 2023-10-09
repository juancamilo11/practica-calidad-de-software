package co.edu.udea.calidadsoftware.models;

import java.time.LocalDateTime;

public class Task {
    private final String id;
    private final String desc;
    private LocalDateTime completedAt;

    public Task(String id, String desc) {
        this.id = id;
        this.desc = desc;
        this.completedAt = null;
    }

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
