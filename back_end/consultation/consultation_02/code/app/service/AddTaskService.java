package code.app.service;

import code.app.dto.RequestDto;
import code.app.dto.ResponseDto;
import code.app.entity.Task;
import code.app.repository.TaskRepository;
import code.app.service.validation.ValidationService;

import java.util.Optional;

public class AddTaskService {
    private final TaskRepository taskRepository;
    private final ValidationService validationService;

    public AddTaskService(TaskRepository taskRepository, ValidationService validationService) {
        this.taskRepository = taskRepository;
        this.validationService = validationService;
    }

    public ResponseDto<Optional<Task>> addNewTask(RequestDto request){
        System.out.println("Received request: " + request);
        // валидация данных

        var validationResult = validationService.validate(request);

        if (validationResult.isEmpty()) {
            Task addedTask = taskRepository.addNewTask(request);
            return new ResponseDto<>(Optional.of(addedTask),validationResult);
        } else {
            return new ResponseDto<>(Optional.empty(), validationResult);
        }

    }
}
