package code.app;

import code.app.repository.TaskRepositoryImpl;
import code.app.service.validation.ValidationService;
import code.app.repository.TaskRepository;
import code.app.service.AddTaskService;
import code.app.service.FindAllTaskService;
import code.app.service.FindTaskByIdService;
import code.app.service.validation.validationRules.*;
import code.app.ui.*;


import java.util.ArrayList;
import java.util.List;

public class TaskApp {
    public static void main(String[] args) {

        List<ValidationRule> validationRules = new ArrayList<>();
        validationRules.add(new TaskNameNullValidation());
        validationRules.add(new TaskDescriptionNullValidation());
        validationRules.add(new TaskNameMinLengthValidation());
        validationRules.add(new TaskNameMaxLengthValidation());
        validationRules.add(new TaskDescriptionMinLengthValidation());
        validationRules.add(new TaskDescriptionMaxLengthValidation());

        TaskRepository repository = new TaskRepositoryImpl();
        code.app.service.validation.ValidationService validationService = new ValidationService(validationRules);

        AddTaskService addTaskService = new AddTaskService(repository,validationService);
        FindAllTaskService findAllTaskService = new FindAllTaskService(repository);
        FindTaskByIdService findTaskByIdService = new FindTaskByIdService(repository);

        List<UIAction> uiActions = new ArrayList<>();
        uiActions.add(new AddTaskUiAction(addTaskService));
        uiActions.add(new FindAllTaskUiAction(findAllTaskService));
        uiActions.add(new FindTaskBuIdUiAction(findTaskByIdService));
        uiActions.add(new ExitUiAction());


        UiMenu uiMenu = new UiMenu(uiActions);

        uiMenu.startUI();
    }
}
