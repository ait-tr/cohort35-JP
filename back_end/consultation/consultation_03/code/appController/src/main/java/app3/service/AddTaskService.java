package app3.service;

import app3.dto.RequestDto;
import app3.dto.ResponseDto;
import app3.entity.Task;
import app3.repository.TaskRepository;
import app3.service.validation.ValidationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
