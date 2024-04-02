package code.app;

import code.app.repository.TaskRepository;
import code.app.repository.TaskRepositoryImpl;
import code.app.service.AddTaskService;
import code.app.service.validation.ValidationService;
import code.app.ui.UI;

public class TaskApp {
    public static void main(String[] args) {
        TaskRepository repository = new TaskRepositoryImpl();
        ValidationService validationService = new ValidationService();
        AddTaskService addTaskService = new AddTaskService(repository,validationService);

        UI ui = new UI(addTaskService);

        ui.start();
    }
}
