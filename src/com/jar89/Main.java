package com.jar89;

public class Main {

    public static void main(String[] args) {
        Developer developer = new Developer();

        //обычные задачи начинаются с 1
        //эпики начинаются с 2
        //подзадачи начинаются с 3
        System.out.println("============ СОЗДАЕМ ОБЫЧНЫЕ ЗАДАЧИ ============");
        developer.createTask(11, "task 1", "medium");
        developer.createTask(11, "task 2", "medium");
        developer.createTask(12, "task 2", "medium");
        developer.createTask(13, "task 3", "medium");

        System.out.println("============ ОТОБОЖАЕМ ВСЕ ЗАДАЧИ ============");
        developer.getTaskList(TaskType.TASK);
        developer.getTaskList(TaskType.EPIC);
        developer.getTaskList(TaskType.SUB_EPIC);

        System.out.println("============ СОЗДАЕМ ПОДЗАДАЧУ ДЛЯ НЕ СУЩЕСТВУЮЩЕГО ЭПИКА ============");
        developer.createSubTask(31, "subTask 1", 21, "easy");
        developer.getTaskList(TaskType.SUB_EPIC);

        System.out.println("============ СОЗДАЕМ ЭПИКИ ============");
        developer.createEpic(21, "epic 1", "hard");
        developer.createEpic(21, "epic 2", "hard");
        developer.createEpic(22, "epic 2", "hard");
        developer.getTaskList(TaskType.EPIC);

        System.out.println("============ СОЗДАЕМ ПОДЗАДАЧИ ============");
        developer.createSubTask(31, "subTask 1", 21, "easy");
        developer.createSubTask(31, "subTask 2", 21, "easy");
        developer.createSubTask(32, "subTask 2", 21, "easy");
        developer.createSubTask(33, "subTask 3", 21, "easy");
        developer.createSubTask(34, "subTask 1", 22, "easy");
        developer.getTaskList(TaskType.SUB_EPIC);
        developer.getAllEpicTasks(21);
        developer.getAllEpicTasks(22);

        System.out.println("============ ЗАГРУЖАЕМ ЗАДАЧИ ПО ID ============");
        developer.getTaskById(11);
        developer.getTaskById(21);
        developer.getTaskById(31);

        System.out.println("============ ИЗМЕНЯЕМ ИМЯ ЗАДАЧ ============");
        developer.updateTaskNameById(11, "Update Task 1");
        developer.updateTaskNameById(21, "Update Epic 1");
        developer.updateTaskNameById(31, "Update SubTask 1");

        System.out.println("============ ИЗМЕНЯЕМ ОПИСАНИЕ ЗАДАЧ ============");
        developer.updateTaskDescriptionById(11, "Update medium");
        developer.updateTaskDescriptionById(21, "Update hard");
        developer.updateTaskDescriptionById(31, "Update easy");

        System.out.println("============ ИЗМЕНЯЕМ СТАТУС ЗАДАЧ ============");
        developer.updateTaskStatusById(11, TaskStatus.IN_PROGRESS);
        developer.updateTaskStatusById(21, TaskStatus.IN_PROGRESS);
        developer.updateTaskStatusById(31, TaskStatus.IN_PROGRESS);
        developer.updateTaskStatusById(21, TaskStatus.IN_PROGRESS);
        developer.updateTaskStatusById(34, TaskStatus.DONE);

        System.out.println("============ ОТОБРАЖАЕМ СПИСКИ ВСЕХ ЗАДАЧ ============");
        developer.getTaskList(TaskType.TASK);
        developer.getTaskList(TaskType.EPIC);
        developer.getTaskList(TaskType.SUB_EPIC);

        System.out.println("============ ОТОБРАЖАЕМ ВСЕ ПОДЗАДАЧИ ДЛЯ ЭПИКА ПО ЕГО ID ============");
        developer.getAllEpicTasks(21);

        System.out.println("============ УДАЛЯЕМ ОБЫЧНУЮ ЗАДАЧУ ПО ID ============");
        developer.removeTaskById(13);
        developer.getTaskList(TaskType.TASK);

        System.out.println("============ УДАЛЯЕМ ЭПИК ПО ID ============");
        developer.removeTaskById(22);
        developer.getAllEpicTasks(22);
        developer.getTaskList(TaskType.EPIC);
        developer.getTaskList(TaskType.SUB_EPIC);

        System.out.println("============ УДАЛЯЕМ ПОДЗАДАЧУ ПО ID ============");
        developer.removeTaskById(32);
        developer.getTaskList(TaskType.SUB_EPIC);
        developer.getAllEpicTasks(21);

        System.out.println("============ УДАЛЯЕМ ВСЕ ЭПИКИ ============");
        developer.deleteTaskList(TaskType.EPIC);
        developer.getTaskList(TaskType.EPIC);
        developer.getTaskList(TaskType.SUB_EPIC);

        System.out.println("============ СОЗДАЕМ ЭПИКИ ============");
        developer.createEpic(21, "epic 1", "hard");
        developer.createEpic(21, "epic 2", "hard");
        developer.createEpic(22, "epic 2", "hard");
        developer.getTaskList(TaskType.EPIC);

        System.out.println("============ СОЗДАЕМ ПОДЗАДАЧИ ============");
        developer.createSubTask(31, "subTask 1", 21, "easy");
        developer.createSubTask(31, "subTask 2", 21, "easy");
        developer.createSubTask(32, "subTask 2", 21, "easy");
        developer.createSubTask(33, "subTask 3", 21, "easy");
        developer.createSubTask(34, "subTask 1", 22, "easy");
        developer.getTaskList(TaskType.SUB_EPIC);
        developer.getAllEpicTasks(21);
        developer.getAllEpicTasks(22);

        System.out.println("============ УДАЛЯЕМ ВСЕ ПОДЗАДАЧИ ============");
        developer.deleteTaskList(TaskType.SUB_EPIC);
        developer.getTaskList(TaskType.EPIC);
        developer.getTaskList(TaskType.SUB_EPIC);
        developer.getAllEpicTasks(21);
    }
}
