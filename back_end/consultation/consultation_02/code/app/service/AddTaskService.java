package code.app.service;

import code.app.dto.RequestDto;
import code.app.dto.ResponseDto;
import code.app.entity.Task;
import code.app.repository.TaskRepository;
import code.app.service.validation.ValidationService;

public class AddTaskService {
    private final TaskRepository taskRepository;
    private final ValidationService validationService;

    public AddTaskService(TaskRepository taskRepository, ValidationService validationService) {
        this.taskRepository = taskRepository;
        this.validationService = validationService;
    }

    public ResponseDto<Task> addNewTask(RequestDto request){
        System.out.println("Received request: " + request);
        // валидация данных

        var validationResult = validationService.validate(request);

        if (validationResult.isEmpty()) {
            Task addedTask = taskRepository.addNewTask(request);
            return new ResponseDto<>(addedTask,validationResult);
        } else {
            return new ResponseDto<>(new Task(0,"",""), validationResult);
        }

    }
}
