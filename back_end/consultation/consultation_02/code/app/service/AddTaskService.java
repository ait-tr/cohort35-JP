package code.app.service;

import code.app.dto.RequestDto;
import code.app.dto.ResponseDto;
import code.app.entity.Task;
import code.app.repository.TaskRepository;
import code.app.service.validation.ValidationService;

import java.util.Optional;

public class AddTaskService {
    private final code.app.repository.TaskRepository taskRepository;
    private final code.app.service.validation.ValidationService validationService;

    public AddTaskService(TaskRepository taskRepository, ValidationService validationService) {
        this.taskRepository = taskRepository;
        this.validationService = validationService;
    }

    public code.app.dto.ResponseDto<Optional<code.app.entity.Task>> addNewTask(RequestDto request){
        System.out.println("Received request: " + request);
        // валидация данных

        var validationResult = validationService.validate(request);

        if (validationResult.isEmpty()) {
            Task addedTask = taskRepository.addNewTask(request);
            return new code.app.dto.ResponseDto<>(Optional.of(addedTask),validationResult);
        } else {
            return new ResponseDto<>(Optional.empty(), validationResult);
        }

    }
}
