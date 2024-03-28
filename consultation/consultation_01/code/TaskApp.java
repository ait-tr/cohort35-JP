package code;

import code.repository.TaskRepository;
import code.repository.TaskRepositoryImpl;
import code.service.AddTaskService;
import code.service.validation.ValidationService;
import code.ui.UI;

public class TaskApp {
    public static void main(String[] args) {
        TaskRepository repository = new TaskRepositoryImpl();
        ValidationService validationService = new ValidationService();
        AddTaskService addTaskService = new AddTaskService(repository,validationService);

        UI ui = new UI(addTaskService);

        ui.start();
    }
}
