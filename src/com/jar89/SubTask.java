package com.jar89;

public class SubTask {
    int id;
    String name;
    int epicId;
    String description;
    TaskStatus status;

    SubTask(int id, String name, int epicId, String description) {
        this.id = id;
        this.name = name;
        this.epicId = epicId;
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
