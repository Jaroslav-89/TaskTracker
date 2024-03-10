package com.jar89;

import java.util.ArrayList;

public class Developer {
    ArrayList<Task> taskList = new ArrayList<Task>();
    ArrayList<Epic> epicList = new ArrayList<Epic>();
    ArrayList<SubTask> subTaskList = new ArrayList<SubTask>();

    public void getTaskList(TaskType type) {
        switch (type) {
            case TASK:
                if (taskList.isEmpty())
                    System.out.println("список обычных задач пуст");
                else
                    for (Task task : taskList) {
                        System.out.println(task.id + " " + task.name + " " + task.description + " " + task.status);
                    }
                return;
            case EPIC:
                if (epicList.isEmpty())
                    System.out.println("список эпик задач пуст");
                else
                    for (Epic task : epicList) {
                        System.out.println(task.id + " " + task.name + " " + task.description + " " + task.status);
                    }
                return;
            case SUB_EPIC:
                if (subTaskList.isEmpty())
                    System.out.println("список подзадач пуст");
                else
                    for (SubTask task : subTaskList) {
                        System.out.println(task.id + " " + task.name + " " + task.epicId + " " + task.description + " " + task.status);
                    }
        }
    }

    public void deleteTaskList(TaskType type) {
        switch (type) {
            case TASK:
                taskList = new ArrayList<Task>();
                System.out.println("список обычных задач удален");
                return;
            case EPIC:
                epicList = new ArrayList<Epic>();
                subTaskList = new ArrayList<SubTask>();
                System.out.println("список эпик задач удален");
                return;
            case SUB_EPIC:
                for (Epic epic : epicList) {
                    epic.removeAllSubTasks();
                }
                subTaskList = new ArrayList<SubTask>();
                System.out.println("список подзадача эпика удален");
        }
    }

    public void createTask(int id, String name, String description) {
        if (checkIdAvailable(id)) {
            Task task = new Task(id, name, description);
            taskList.add(task);
            System.out.println("Создана обычная задача " + task.name);
        } else {
            System.out.println("Такое id уже существует, введите другое id");
        }
    }

    public void createEpic(int id, String name, String description) {
        if (checkIdAvailable(id)) {
            Epic epic = new Epic(id, name, description);
            epicList.add(epic);
            System.out.println("Создана эпик задача " + epic.name);
        } else {
            System.out.println("Такое id уже существует, введите другое id");
        }
    }

    public void createSubTask(int id, String name, int epicId, String description) {
        if (checkIdAvailable(id)) {
            if (epicList.isEmpty()) {
                System.out.println("Невозможно создать подзадачу тк эпика с таким id не сущесвует");
                return;
            }
            for (Epic epic : epicList) {
                if (epic.id == epicId) {
                    SubTask subTask = new SubTask(id, name, epicId, description);
                    epic.addSubTask(subTask);
                    subTaskList.add(subTask);
                    System.out.println("Создана подзадача эпика " + epicId + " " + subTask.name);
                    break;
                }
            }
        } else {
            System.out.println("Такое id уже существует, введите другое id");
        }
    }

    private Boolean checkIdAvailable(int id) {
        for (Task task : taskList) {
            if (task.id == id) {
                return false;
            }
        }
        for (Epic epic : epicList) {
            if (epic.id == id) {
                return false;
            }
        }
        for (SubTask subTask : subTaskList) {
            if (subTask.id == id) {
                return false;
            }
        }
        return true;
    }

    public void getTaskById(int id) {
        for (Task task : taskList) {
            if (task.id == id) {
                System.out.println(task.id + " " + task.name + " " + task.description + " " + task.status);
                return;
            }
        }
        for (Epic epic : epicList) {
            if (epic.id == id) {
                System.out.println(epic.id + " " + epic.name + " " + epic.description + " " + epic.status);
                return;
            }
        }
        for (SubTask subTask : subTaskList) {
            if (subTask.id == id) {
                System.out.println(subTask.id + " " + subTask.name + " " + subTask.epicId + " " + subTask.description + " " + subTask.status);
                return;
            }
        }
    }

    public void updateTaskNameById(int id, String name) {
        for (Task task : taskList) {
            if (task.id == id) {
                task.updateTaskName(name);
                System.out.println("Имя обычной задачи обновлено " + task.name);
                for (Task item : taskList) {
                    System.out.println(item.name);
                }
                return;
            }
        }
        for (Epic epic : epicList) {
            if (epic.id == id) {
                epic.updateTaskName(name);
                System.out.println("Имя эпик задачи обновлено " + epic.name);
                for (Epic item : epicList) {
                    System.out.println(item.name);
                }
                return;
            }
        }
        for (SubTask subTask : subTaskList) {
            if (subTask.id == id) {
                subTask.updateTaskName(name);
                for (Epic epic : epicList) {
                    if (epic.id == subTask.epicId) {
                        epic.updateSubTaskList(subTask);
                    }
                }
                System.out.println("Имя подзадачи эпика обновлено " + subTask.name);
                for (SubTask item : subTaskList) {
                    System.out.println(item.name);
                }
                return;
            }
        }
    }

    public void updateTaskDescriptionById(int id, String description) {
        for (Task task : taskList) {
            if (task.id == id) {
                task.updateTaskDescription(description);
                System.out.println("Описание обычной задачи обновлено " + task.description);
                for (Task item : taskList) {
                    System.out.println(item.description);
                }
                return;
            }
        }
        for (Epic epic : epicList) {
            if (epic.id == id) {
                epic.updateTaskDescription(description);
                System.out.println("Описание эпик задачи обновлено " + epic.description);
                for (Epic item : epicList) {
                    System.out.println(item.description);
                }
                return;
            }
        }
        for (SubTask subTask : subTaskList) {
            if (subTask.id == id) {
                subTask.updateTaskDescription(description);
                for (Epic epic : epicList) {
                    if (epic.id == subTask.epicId) {
                        epic.updateSubTaskList(subTask);
                    }
                }
                System.out.println("Описание подзадачи эпика обновлено " + subTask.description);
                for (SubTask item : subTaskList) {
                    System.out.println(item.description);
                }
                return;
            }
        }
    }

    public void updateTaskStatusById(int id, TaskStatus status) {
        for (Task task : taskList) {
            if (task.id == id) {
                task.updateTaskStatus(status);
                System.out.println("Статус обычной задачи обновлен " + task.status.toString());
                for (Task item : taskList) {
                    System.out.println(item.status.toString());
                }
                return;
            }
        }
        for (Epic epic : epicList) {
            if (epic.id == id) {
                System.out.println("Статус эпик задачи зависит от статусов подзадач и не может быть изменен напрямую");
                for (Epic item : epicList) {
                    System.out.println(item.status.toString());
                }
                return;
            }
        }
        for (SubTask subTask : subTaskList) {
            if (subTask.id == id) {
                subTask.updateTaskStatus(status);
                for (Epic epic : epicList) {
                    if (epic.id == subTask.epicId) {
                        epic.updateSubTaskList(subTask);
                    }
                }
                System.out.println("Статус подзадачи эпика обновлен " + subTask.status.toString());
                for (SubTask item : subTaskList) {
                    System.out.println(item.status.toString());
                }
                return;
            }
        }
    }

    public void removeTaskById(int id) {
        for (Task task : taskList) {
            if (task.id == id) {
                taskList.remove(task);
                return;
            }
        }
        for (Epic epic : epicList) {
            if (epic.id == id) {
                epicList.remove(epic);
                ArrayList<SubTask> newSubTask = new ArrayList<SubTask>();
                for (SubTask subTask : subTaskList) {
                    if (subTask.epicId != epic.id) {
                        newSubTask.add(subTask);
                    }
                }
                subTaskList = newSubTask;
                return;
            }
        }
        for (SubTask subTask : subTaskList) {
            if (subTask.id == id) {
                for (Epic epic : epicList) {
                    if (subTask.epicId == epic.id) {
                        epic.removeSubTask(subTask);
                    }
                }
                subTaskList.remove(subTask);
                return;
            }
        }
    }

    public void getAllEpicTasks(int id) {
        for (Epic epic : epicList) {
            if (epic.id == id) {
                for (SubTask item : epic.subTaskList) {
                    System.out.println(item.id + " " + item.name + " " + item.epicId + " " + item.description + " " + item.status);
                }
            }
        }
    }
}
