package com.jar89;

public class Task {
    int id;
    String name;
    String description;
    TaskStatus status;

    Task(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = TaskStatus.TO_DO;
    }

    public void updateTaskStatus(TaskStatus status) {
        this.status = status;
    }

    public void updateTaskName(String name) {
        this.name = name;
    }

    public void updateTaskDescription(String description) {
        this.description = description;
    }
}
