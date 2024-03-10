package com.jar89;

import java.util.ArrayList;

import static com.jar89.TaskStatus.IN_PROGRESS;

public class Epic {
    int id;
    String name;
    String description;
    TaskStatus status;
    ArrayList<SubTask> subTaskList;

    Epic(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = TaskStatus.TO_DO;
        this.subTaskList = new ArrayList<SubTask>();
    }

    public void addSubTask(SubTask subTask) {
        this.subTaskList.add(subTask);
    }

    public void removeSubTask(SubTask subTask) {
        this.subTaskList.remove(subTask);
        checkAndUpdateEpicStatus();
    }

    public void removeAllSubTasks() {
        this.subTaskList.clear();
    }

    public void updateSubTaskList(SubTask subTask) {
        for (SubTask task : subTaskList) {
            if (task.id == subTask.id) {
                subTaskList.remove(task);
                subTaskList.add(subTask);
                checkAndUpdateEpicStatus();
                break;
            }
        }
    }

    private void checkAndUpdateEpicStatus() {
        int toDo = 0;
        int done = 0;
        for (SubTask subTask : subTaskList) {
            switch (subTask.status) {
                case TO_DO:
                    toDo++;
                    break;
                case IN_PROGRESS:
                    status = IN_PROGRESS;
                    break;
                case DONE:
                    done++;
                    break;
            }
        }
        if (done == subTaskList.size())
            status = TaskStatus.DONE;
        else if (toDo == subTaskList.size())
            status = TaskStatus.TO_DO;
    }

    public void updateTaskName(String name) {
        this.name = name;
    }

    public void updateTaskDescription(String description) {
        this.description = description;
    }
}
