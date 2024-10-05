package org.example;

public class Item {
    private String task;
    private String importance;

    public Item(String task, String importance) {
        this.task = task;
        this.importance = importance;
    }
    public Item(String task) {
        this.task = task;
        this.importance = "Medium";
    }
    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public String getImportance() {
        return importance;
    }
    public void setImportance(String importance) {
        this.importance = importance;
    }
    public String toString() {
        return importance + ": " + task;
    }

}
