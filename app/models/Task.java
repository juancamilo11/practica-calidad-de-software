package app.models;

import java.time.LocalDateTime;

public class Task {
    public String id;
    public String desc;
    public LocalDateTime completedAt;

    public Task(String id, String desc) {
        this.id = id;
        this.desc = desc;
        this.completedAt = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
