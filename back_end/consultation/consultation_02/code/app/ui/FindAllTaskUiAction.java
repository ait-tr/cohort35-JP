package code.app.ui;

import code.app.dto.TaskDto;
import code.app.service.FindAllTaskService;

import java.util.List;

public class FindAllTaskUiAction implements UIAction{

    private final code.app.service.FindAllTaskService findAllTaskService;

    public FindAllTaskUiAction(FindAllTaskService findAllTaskService) {
        this.findAllTaskService = findAllTaskService;
    }


    @Override
    public void execute() {
       var response = findAllTaskService.findAll();

        System.out.println("Список задач:");
        System.out.println("-------------");
        if (response.getErrors().isEmpty()) {
        printData(response.getResult());
        } else {
            System.out.println(response.getErrors());
        }
    }

    @Override
    public String getActionName() {
        return "Find All Tasks";
    }

    private void printData(List<code.app.dto.TaskDto> dtos) {
        for (TaskDto taskDto : dtos){
            System.out.println(taskDto);
        }
    }
}
