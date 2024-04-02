package code.app.service;

import code.app.dto.ResponseDto;
import code.app.dto.TaskDto;
import code.app.entity.Task;
import code.app.repository.TaskRepository;
import code.app.service.validation.validationRules.CoreError;

import java.util.ArrayList;
import java.util.List;

public class FindAllTaskService {
    private code.app.repository.TaskRepository repository;

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
