package ait.todo;

import ait.todo.model.Task;
import ait.todo.model.ToDoList;

import java.util.Date;
import java.util.List;

public class ToDoAppl {
    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();

        Task task1 = new Task("Buy groceries", "Milk, eggs, bread", new Date());
        Task task2 = new Task("Finish project", "Complete coding and testing", new Date());

        todoList.addTask(task1);
        todoList.addTask(task2);

        System.out.println("Tasks in the list:");
        List<Task> tasks = todoList.getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ". " + tasks.get(i));
        }

        // Можно пометить задачу как выполненную
        todoList.markTaskAsCompleted(0);
        System.out.println("Marked task as completed.");

        System.out.println("Updated task list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ". " + tasks.get(i));
        }
    }
}




