package code.app.ui;

import code.app.dto.RequestDto;
import code.app.service.AddTaskService;

import java.util.Scanner;

public class AddTaskUiAction implements UIAction{

    private final AddTaskService addTaskService;

    public AddTaskUiAction(AddTaskService addTaskService) {
        this.addTaskService = addTaskService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter task name:");
        String taskName = scanner.nextLine();
        System.out.println("Please enter task description:");
        String taskDescription = scanner.nextLine();

        var request = new RequestDto(taskName, taskDescription);
        addTaskService.addNewTask(request);

    }

    @Override
    public String getActionName() {
        return "Add New Task";
    }
}
