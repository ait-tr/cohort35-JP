package code.app.ui;

import code.app.dto.TaskDto;
import code.app.service.FindAllTaskService;
import code.app.service.FindTaskByIdService;

import java.util.List;
import java.util.Scanner;

public class FindTaskBuIdUiAction implements UIAction{

    private final FindTaskByIdService findTaskByIdService;

    public FindTaskBuIdUiAction(FindTaskByIdService findTaskByIdService) {
        this.findTaskByIdService = findTaskByIdService;
    }


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter task id:");
        Integer taskId = scanner.nextInt();

       var response = findTaskByIdService.findById(taskId);

        if (response.getErrors().isEmpty()) {
            System.out.println("Найдена задача:");
            System.out.println("-------------");
            System.out.println(response.getResult().getName());
            System.out.println(response.getResult().getDescription());
        } else {
            System.out.println(response.getErrors());
        }
    }

    @Override
    public String getActionName() {
        return "Find Task By ID";
    }


}
