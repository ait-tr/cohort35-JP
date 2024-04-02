package code.app.ui;

import code.app.dto.RequestDto;
import code.app.service.AddTaskService;

import java.util.Scanner;

public class UI {

    AddTaskService addTaskService;

    public UI(AddTaskService addTaskService) {
        this.addTaskService = addTaskService;
    }

    public void start(){

        while (true){
            System.out.println("Please enter your choice:");
            System.out.println("1. Add new task");
            System.out.println("2. Find task by Id");
            System.out.println("3. Find Task by name new task");
            System.out.println("4. Exit");

            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput) {
                case 1:
                    System.out.println("Please enter task name:");
                    String taskName = scanner.nextLine();
                    System.out.println("Please enter task description:");
                    String taskDescription = scanner.nextLine();
                    addTaskService.addNewTask(new RequestDto(taskName, taskDescription));
                    break;
                case 4:
                    System.exit(0);


            }
        }
    }
}
