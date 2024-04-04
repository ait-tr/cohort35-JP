package service;

import dto.ResponseDto;
import dto.TaskDto;
import entity.Task;
import repository.TaskRepository;
import service.validation.validationRules.CoreError;

import java.util.ArrayList;
import java.util.List;

public class FindAllTaskService {
    private TaskRepository repository;

    public FindAllTaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public ResponseDto<List<TaskDto>> findAll(){

        List<Task> tasks = repository.findAll();

        List<TaskDto> dtos = new ArrayList<>();

        List<CoreError> errors = new ArrayList<>();

        if (tasks.isEmpty()) {
            errors.add(new CoreError("Task database is empty"));
        } else {
            dtos = tasks.stream()
                    .map(this::converter)
                    .toList();
        }

        return new ResponseDto<>(dtos,errors);
    }

    private TaskDto converter(Task task) {
        return new TaskDto(task.getName(), task.getDescription());
    }
}
